package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.RoomDto;
import org.example.demo_11.model.Price;
import org.example.demo_11.model.Room;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomPriceService {

    private final PriceRepository priceRepository;

    public RoomDto calculateRoomPrice(Room room) {
        Price price = priceRepository.findById(1L).orElse(new Price());

        RoomDto dto = new RoomDto();
        dto.setArea(room.getArea() != null ? room.getArea() : 0);
        dto.setPerimeter(room.getPerimeter() != null ? room.getPerimeter() : 0);

        long total = 0;

        // ✅ العزل البارد
        long coldInsulation = price != null ? price.getColdInsulationForFloors() : 0;
        dto.setPriceFloorColdInsulation(coldInsulation);
        dto.setPriceFloorColdInsulationFormula(coldInsulation + " جنيه (ثابت)");
        total += coldInsulation;

        // ✅ الأرضية
        long floorPrice = 0;
        String floorFormula = "";
        if (room.getFloorWallMaterial() != null) {
            floorPrice = room.getFloorWallMaterial()
                    .createStrategy(price, dto.getArea(), dto.getPerimeter())
                    .calculatePrice();
            floorFormula = buildFloorFormula(room.getFloorWallMaterial(), dto.getArea());
        }
        dto.setFloorMaterialSTR(room.getFloorWallMaterial() != null ?
                room.getFloorWallMaterial().getArabicName() : "");
        dto.setPriceFloorMaterial(floorPrice);
        dto.setPriceFloorMaterialFormula(floorFormula);
        dto.setFloorMaterial(room.getFloorWallMaterial());
        total += floorPrice;

        // ✅ الحوائط
        long wallPrice = 0;
        String wallFormula = "";
        if (room.getWallType() != null) {
            wallPrice = room.getWallType()
                    .createStrategy(price, dto.getArea(), dto.getPerimeter())
                    .calculatePrice();
            wallFormula = buildWallFormula(room.getWallType(), dto.getPerimeter());
        }
        dto.setWallMaterialSTR(room.getWallType() != null ?
                room.getWallType().getArabicName() : "");
        dto.setPriceWallMaterial(wallPrice);
        dto.setPriceWallMaterialFormula(wallFormula);
        dto.setWallMaterial(room.getWallType());
        total += wallPrice;

        // ✅ السقف
        long ceilingPrice = 0;
        String ceilingFormula = "";
        if (room.getCeilingType() != null) {
            ceilingPrice = room.getCeilingType()
                    .createStrategy(price)
                    .calculatePrice(dto.getArea(), dto.getPerimeter());
            ceilingFormula = buildCeilingFormula(room.getCeilingType(), dto.getArea(), dto.getPerimeter());
        }
        dto.setCeilingTypeSTR(room.getCeilingType() != null ?
                room.getCeilingType().getNameAr() : "");
        dto.setCeilingTypePeice(ceilingPrice);
        dto.setCeilingTypePeiceFormula(ceilingFormula);
        total += ceilingPrice;

        // ✅ الشفاط
        long exhaustPrice = 0;
        String exhaustFormula = "";
        if (room.getExhaustType() != null) {
            exhaustPrice = room.getExhaustType()
                    .createStrategy(price)
                    .calculatePrice();
            exhaustFormula = buildExhaustFormula(room.getExhaustType());
        }
        dto.setExhaustMaterialSTR(room.getExhaustType() != null ?
                room.getExhaustType().getArabicName() : "");
        dto.setPriceExhaust(exhaustPrice);
        dto.setPriceExhaustFormula(exhaustFormula);
        dto.setExhaustType(room.getExhaustType());
        total += exhaustPrice;

        dto.setTotalPrice(total);
        dto.setTotalPriceFormula(buildTotalFormula(dto));

        return dto;
    }

    private String buildFloorFormula(org.example.demo_11.eunms.floorwall.FloorMaterial material,
                                     Double area) {
        // الباركيه HDF و SPC بيضرب في 1.2
        boolean isParquet = material.name().contains("Parquet") &&
                (material.name().contains("HDF") || material.name().contains("SPC"));

        double actualArea = isParquet ? area * 1.2 : area;

        if (isParquet) {
            return String.format("(مواد + عمالة) × %.2f م² × 1.2 (هالك باركيه) = السعر", area);
        } else {
            return String.format("(مواد + عمالة) × %.2f م² = السعر", actualArea);
        }
    }

    private String buildWallFormula(org.example.demo_11.eunms.floorwall.WallType wallType,
                                    Double perimeter) {
        return String.format("(مواد + عمالة) × %.2f م (المحيط) × 3 م (الارتفاع) = السعر",
                perimeter);
    }

    private String buildCeilingFormula(org.example.demo_11.eunms.ceiling.CeilingType ceilingType,
                                       Double area, Double perimeter) {
        switch (ceilingType) {
            case BEIT_NOOR:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + إضاءة خلفية LED = السعر",
                        perimeter);
            case SHADOW_GAP:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + باند 51 = السعر",
                        perimeter);
            case SHADOW_GAP_LIGHT:
                return String.format("(مواد + عمالة) × %.2f م + (باند 51 × %.2f م²) = السعر",
                        perimeter, area);
            case CORNICE_FUTEC_SMALL:
                return "كرانيش فيوتك صغير (مواد + عمالة) = السعر الثابت";
            case CORNICE_FUTEC_LARGE:
                return "كرانيش فيوتك كبير (مواد + عمالة) = السعر الثابت";

            // ✅ النوع الجديد (Flat)
            case FLAT:
                return String.format("(مواد + عمالة) ×  م² = المساحة", area);

            default:
                return "غير محدد";
        }
    }

    private String buildExhaustFormula(org.example.demo_11.eunms.exhaust.ExhaustType exhaustType) {
        switch (exhaustType) {
            case WINDOW_EXHAUST:
                return "شفاط شباك (مواد + عمالة تركيب) = السعر";
            case CEILING_EXHAUST:
                return "شفاط سقف (مواد + عمالة تركيب) = السعر";
            case NONE:
                return "لا يوجد شفاط - 0 جنيه";
            default:
                return "غير محدد";
        }
    }

    private String buildTotalFormula(RoomDto dto) {
        StringBuilder formula = new StringBuilder();
        formula.append("المجموع = ");

        boolean hasItems = false;

        if (dto.getPriceFloorColdInsulation() != null && dto.getPriceFloorColdInsulation() > 0) {
            formula.append("عزل بارد (").append(dto.getPriceFloorColdInsulation()).append(")");
            hasItems = true;
        }

        if (dto.getPriceFloorMaterial() != null && dto.getPriceFloorMaterial() > 0) {
            if (hasItems) formula.append(" + ");
            formula.append("أرضية (").append(dto.getPriceFloorMaterial()).append(")");
            hasItems = true;
        }

        if (dto.getPriceWallMaterial() != null && dto.getPriceWallMaterial() > 0) {
            if (hasItems) formula.append(" + ");
            formula.append("حوائط (").append(dto.getPriceWallMaterial()).append(")");
            hasItems = true;
        }

        if (dto.getCeilingTypePeice() != null && dto.getCeilingTypePeice() > 0) {
            if (hasItems) formula.append(" + ");
            formula.append("سقف (").append(dto.getCeilingTypePeice()).append(")");
            hasItems = true;
        }

        if (dto.getPriceExhaust() != null && dto.getPriceExhaust() > 0) {
            if (hasItems) formula.append(" + ");
            formula.append("شفاط (").append(dto.getPriceExhaust()).append(")");
            hasItems = true;
        }

        formula.append(" = ").append(dto.getTotalPrice()).append(" جنيه");

        return formula.toString();
    }
}