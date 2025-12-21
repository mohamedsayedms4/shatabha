package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.ResidentialUnitDto;
import org.example.demo_11.eunms.shutter.ShutterType;
import org.example.demo_11.model.Price;
import org.example.demo_11.model.ResidentialUnit;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentialUnitPriceService {

    private final PriceRepository priceRepository;

    public ResidentialUnitDto calculateResidentialUnitPrice(ResidentialUnit unit) {
        Price priceFromDb = priceRepository.findById(1L).orElse(new Price());

        ResidentialUnitDto dto = new ResidentialUnitDto();

        dto.setTotalArea(unit.getTotalArea() != null ? unit.getTotalArea() : 0);
        dto.setRoomsNumber(unit.getRoomsNumber() != 0 ? unit.getRoomsNumber() : 0);

        // ✅ (جديد) بيانات العميل
        dto.setCustomerName(unit.getCustomerName());
        dto.setCustomerPhone(unit.getCustomerPhone());

        dto.setLocation(unit.getLocation());
        dto.setUnitCollection(unit.getUnitCollection());
        dto.setFinishingStatus(unit.getFinishingStatus());

        long total = 0;

        long previousFinishingDemolition = calculateDemolitionPrice(unit, priceFromDb);
        dto.setPreviousFinishingDemolition(previousFinishingDemolition);
        dto.setDemolitionFormula(getDemolitionFormula(unit, priceFromDb));
        total += previousFinishingDemolition;

        long electricalInstallation = calculateElectricalInstallation(unit, priceFromDb);
        dto.setElectricalInstallation(electricalInstallation);
        dto.setElectricalFormula(getElectricalFormula(unit, priceFromDb));
        total += electricalInstallation;

        long cementAndMaterialSupply = calculateCementAndMaterialSupply(unit, priceFromDb);
        dto.setCementAndMaterialSupply(cementAndMaterialSupply);
        dto.setCementMaterialFormula(getCementMaterialFormula(unit, priceFromDb));
        total += cementAndMaterialSupply;

        long cementSandAndMaterialsSupply = calculateCementSandAndMaterialsSupply(unit, priceFromDb);
        dto.setCementSandAndMaterialsSupply(cementSandAndMaterialsSupply);
        dto.setCementSandFormula(getCementSandFormula(unit, priceFromDb));
        total += cementSandAndMaterialsSupply;

        long spotPrice = unit.getSpot() != null ? calculateSpotPrice(unit, priceFromDb) : 0;
        dto.setSpotPrice(spotPrice);
        dto.setSpotTypeStr(unit.getSpot() != null ? unit.getSpot().getArabicName() : "");
        dto.setSpotType(unit.getSpot());
        dto.setSpotFormula(getSpotFormula(unit, priceFromDb));
        total += spotPrice;

        long magneticTrackPrice = unit.getMAGNTIC_TRACK() != null ? calculateMagneticTrackPrice(unit, priceFromDb) : 0;
        dto.setMagneticTrackPrice(magneticTrackPrice);
        dto.setMagneticTrackTypeStr(unit.getMAGNTIC_TRACK() != null ? unit.getMAGNTIC_TRACK().getArabicName() : "");
        dto.setMagneticTrackType(unit.getMAGNTIC_TRACK());
        dto.setMagneticTrackFormula(getMagneticTrackFormula(unit, priceFromDb));
        total += magneticTrackPrice;

        long interiorDoorsPrice = unit.getInterDoor() != null && unit.getInterDoorCounter() != 0
                ? unit.getInterDoor().createStrategy(priceFromDb).calculatePrice() * unit.getInterDoorCounter()
                : 0;
        dto.setInteriorDoorsPrice(interiorDoorsPrice);
        dto.setInteriorDoorsType(unit.getInterDoor());
        dto.setInteriorDoorsCount(unit.getInterDoorCounter() != 0 ? unit.getInterDoorCounter() : 0);
        dto.setInteriorDoorsFormula(getInteriorDoorsFormula(unit, priceFromDb));
        total += interiorDoorsPrice;

        long exteriorDoorsPrice = unit.getOutDoor() != null ? unit.getOutDoor().createStrategy(priceFromDb).calculatePrice() : 0;
        dto.setExteriorDoorsPrice(exteriorDoorsPrice);
        dto.setExteriorDoorsType(unit.getOutDoor());
        dto.setExteriorDoorsFormula(getExteriorDoorsFormula(unit, priceFromDb));
        total += exteriorDoorsPrice;

        if (unit.getShutterTypes() != null && !unit.getShutterTypes().isEmpty() && unit.getWidowCounter() != null) {
            List<String> shutterDetails = new ArrayList<>();
            List<String> shutterFormulas = new ArrayList<>();
            long totalShutterPrice = 0;

            for (ShutterType shutterType : unit.getShutterTypes()) {
                long shutterTypePrice = shutterType.createStrategy(priceFromDb).calculatePrice();
                long shutterTotalForType = shutterTypePrice * unit.getWidowCounter();

                shutterDetails.add(shutterType.getArabicName() + ": " + shutterTotalForType);
                shutterFormulas.add(String.format("%s: (مواد + عمالة) × %d = %d × %d = %d",
                        shutterType.getArabicName(), unit.getWidowCounter(),
                        shutterTypePrice, unit.getWidowCounter(), shutterTotalForType));
                totalShutterPrice += shutterTotalForType;
            }

            dto.setShutterPrice(totalShutterPrice);
            dto.setShutterTypes(unit.getShutterTypes());
            dto.setShutterCount(unit.getWidowCounter());
            dto.setShutterDetails(shutterDetails);
            dto.setShutterFormula(String.join(" | ", shutterFormulas));
            total += totalShutterPrice;
        }

        long windowsPrice = unit.getWindowType() != null && unit.getWidowCounter() != null
                ? unit.getWindowType().createStrategy(priceFromDb).calculatePrice() * unit.getWidowCounter()
                : 0;
        dto.setWindowsPrice(windowsPrice);
        dto.setWindowsType(unit.getWindowType());
        dto.setWindowsCount(unit.getWidowCounter() != null ? unit.getWidowCounter() : 0);
        dto.setWindowsFormula(getWindowsFormula(unit, priceFromDb));
        total += windowsPrice;

        dto.setTotalPrice(total);
        return dto;
    }

    private long calculateDemolitionPrice(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;

        if (area <= 100) return price.getPreviousFinishingDemolitionLessThan100Sqm();
        else if (area <= 150) return price.getPreviousFinishingDemolitionLessThan150Sqm();
        else return price.getPreviousFinishingDemolitionMoreThan150Sqm();
    }

    private long calculateElectricalInstallation(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;

        if (area <= 100) return price.getElectricalInstallationLessThan100SqmCategory() +
                price.getElectricalInstallationLessThan100SqmManufacturers();
        else if (area <= 150) return price.getElectricalInstallationLessThan150SqmCategory() +
                price.getElectricalInstallationLessThan150SqmManufacturers();
        else return price.getElectricalInstallationMoreThan150SqmCategory() +
                    price.getElectricalInstallationMoreThan150SqmManufacturers();
    }

    private long calculateCementAndMaterialSupply(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;

        if (area <= 100) return price.getCementAndMaterialSupplyLessThan100Sqm();
        else if (area <= 150) return price.getCementAndMaterialSupplyLessThan150Sqm();
        else return price.getCementAndMaterialSupplyMoreThan150Sqm();
    }

    private long calculateCementSandAndMaterialsSupply(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;

        if (area <= 100) return price.getCementSandAndMaterialsSupplyLessThan100Sqm();
        else if (area <= 150) return price.getCementSandAndMaterialsSupplyLessThan150Sqm();
        else return price.getCementSandAndMaterialsSupplyMoreThan150Sqm();
    }

    private long calculateSpotPrice(ResidentialUnit unit, Price price) {
        if (unit.getSpot() == null) return 0L;

        return switch (unit.getSpot()) {
            case SINGLE_SPOT -> 80L * (price.getLightingPrices().getSpotSingleMaterials() + price.getLightingPrices().getSpotSingleLabor());
            case DOUBLE_SPOT -> 40L * (price.getLightingPrices().getSpotDoubleMaterials() + price.getLightingPrices().getSpotDoubleLabor());
            case NONE -> 0L;
        };
    }

    private long calculateMagneticTrackPrice(ResidentialUnit unit, Price price) {
        if (unit.getMAGNTIC_TRACK() == null || unit.getRoomsNumber() == 0) return 0L;

        return switch (unit.getMAGNTIC_TRACK()) {
            case MAGNTIC_TRACK_ROOM -> 2L * unit.getRoomsNumber() *
                    (price.getLightingPrices().getMagneticTrackLightingMaterials() + price.getLightingPrices().getMagneticTrackLightingLabor());
            case MAGNTIC_TRACK_RESPTION -> 4L * unit.getRoomsNumber() *
                    (price.getLightingPrices().getMagneticTrackLightingMaterials() + price.getLightingPrices().getMagneticTrackLightingLabor());
            case NONE -> 0L;
        };
    }

    private String getDemolitionFormula(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;
        String category;
        long value;

        if (area <= 100) {
            category = "أقل من 100 م²";
            value = price.getPreviousFinishingDemolitionLessThan100Sqm();
        } else if (area <= 150) {
            category = "من 100 إلى 150 م²";
            value = price.getPreviousFinishingDemolitionLessThan150Sqm();
        } else {
            category = "أكثر من 150 م²";
            value = price.getPreviousFinishingDemolitionMoreThan150Sqm();
        }

        return String.format("المساحة %d م² (%s) = %d", area, category, value);
    }

    private String getElectricalFormula(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;
        String category;
        long categoryValue, manufacturersValue;

        if (area <= 100) {
            category = "أقل من 100 م²";
            categoryValue = price.getElectricalInstallationLessThan100SqmCategory();
            manufacturersValue = price.getElectricalInstallationLessThan100SqmManufacturers();
        } else if (area <= 150) {
            category = "من 100 إلى 150 م²";
            categoryValue = price.getElectricalInstallationLessThan150SqmCategory();
            manufacturersValue = price.getElectricalInstallationLessThan150SqmManufacturers();
        } else {
            category = "أكثر من 150 م²";
            categoryValue = price.getElectricalInstallationMoreThan150SqmCategory();
            manufacturersValue = price.getElectricalInstallationMoreThan150SqmManufacturers();
        }

        return String.format("المساحة %d م² (%s): التصنيف %d + الشركات المصنعة %d = %d",
                area, category, categoryValue, manufacturersValue, categoryValue + manufacturersValue);
    }

    private String getCementMaterialFormula(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;
        String category;
        long value;

        if (area <= 100) {
            category = "أقل من 100 م²";
            value = price.getCementAndMaterialSupplyLessThan100Sqm();
        } else if (area <= 150) {
            category = "من 100 إلى 150 م²";
            value = price.getCementAndMaterialSupplyLessThan150Sqm();
        } else {
            category = "أكثر من 150 م²";
            value = price.getCementAndMaterialSupplyMoreThan150Sqm();
        }

        return String.format("المساحة %d م² (%s) = %d", area, category, value);
    }

    private String getCementSandFormula(ResidentialUnit unit, Price price) {
        long area = unit.getTotalArea() != null ? unit.getTotalArea() : 0;
        String category;
        long value;

        if (area <= 100) {
            category = "أقل من 100 م²";
            value = price.getCementSandAndMaterialsSupplyLessThan100Sqm();
        } else if (area <= 150) {
            category = "من 100 إلى 150 م²";
            value = price.getCementSandAndMaterialsSupplyLessThan150Sqm();
        } else {
            category = "أكثر من 150 م²";
            value = price.getCementSandAndMaterialsSupplyMoreThan150Sqm();
        }

        return String.format("المساحة %d م² (%s) = %d", area, category, value);
    }

    private String getSpotFormula(ResidentialUnit unit, Price price) {
        if (unit.getSpot() == null) return "لا يوجد";

        return switch (unit.getSpot()) {
            case SINGLE_SPOT -> {
                long materials = price.getLightingPrices().getSpotSingleMaterials();
                long labor = price.getLightingPrices().getSpotSingleLabor();
                long total = 80L * (materials + labor);
                yield String.format("سينجل سبوت: 80 × (مواد %d + عمالة %d) = 80 × %d = %d",
                        materials, labor, materials + labor, total);
            }
            case DOUBLE_SPOT -> {
                long materials = price.getLightingPrices().getSpotDoubleMaterials();
                long labor = price.getLightingPrices().getSpotDoubleLabor();
                long total = 40L * (materials + labor);
                yield String.format("دبل سبوت: 40 × (مواد %d + عمالة %d) = 40 × %d = %d",
                        materials, labor, materials + labor, total);
            }
            case NONE -> "لا يوجد = 0";
        };
    }

    private String getMagneticTrackFormula(ResidentialUnit unit, Price price) {
        if (unit.getMAGNTIC_TRACK() == null || unit.getRoomsNumber() == 0) return "لا يوجد";

        long materials = price.getLightingPrices().getMagneticTrackLightingMaterials();
        long labor = price.getLightingPrices().getMagneticTrackLightingLabor();
        int rooms = unit.getRoomsNumber();

        return switch (unit.getMAGNTIC_TRACK()) {
            case MAGNTIC_TRACK_ROOM -> {
                long total = 2L * rooms * (materials + labor);
                yield String.format("ماجنتك تراك غرفة: 2 × عدد الغرف %d × (مواد %d + عمالة %d) = 2 × %d × %d = %d",
                        rooms, materials, labor, rooms, materials + labor, total);
            }
            case MAGNTIC_TRACK_RESPTION -> {
                long total = 4L * rooms * (materials + labor);
                yield String.format("ماجنتك تراك ريسيبشن: 4 × عدد الغرف %d × (مواد %d + عمالة %d) = 4 × %d × %d = %d",
                        rooms, materials, labor, rooms, materials + labor, total);
            }
            case NONE -> "لا يوجد = 0";
        };
    }

    private String getInteriorDoorsFormula(ResidentialUnit unit, Price price) {
        if (unit.getInterDoor() == null || unit.getInterDoorCounter() == 0) {
            return "لا يوجد أبواب داخلية";
        }

        long pricePerDoor = unit.getInterDoor().createStrategy(price).calculatePrice();
        long total = pricePerDoor * unit.getInterDoorCounter();

        return String.format("%s: (مواد + عمالة) × العدد = %d × %d = %d",
                unit.getInterDoor().getArabicName(), pricePerDoor, unit.getInterDoorCounter(), total);
    }

    private String getExteriorDoorsFormula(ResidentialUnit unit, Price price) {
        if (unit.getOutDoor() == null) {
            return "لا يوجد باب خارجي";
        }

        long doorPrice = unit.getOutDoor().createStrategy(price).calculatePrice();

        return String.format("%s: مواد + عمالة = %d",
                unit.getOutDoor().getArabicName(), doorPrice);
    }

    private String getWindowsFormula(ResidentialUnit unit, Price price) {
        if (unit.getWindowType() == null || unit.getWidowCounter() == null || unit.getWidowCounter() == 0) {
            return "لا يوجد نوافذ";
        }

        long pricePerWindow = unit.getWindowType().createStrategy(price).calculatePrice();
        long total = pricePerWindow * unit.getWidowCounter();

        return String.format("%s: (مواد + عمالة) × العدد = %d × %d = %d",
                unit.getWindowType().getArabicName(), pricePerWindow, unit.getWidowCounter(), total);
    }
}
