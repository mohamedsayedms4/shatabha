package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.RoomDto;
import org.example.demo_11.model.*;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomPriceService {

    private final PriceRepository priceRepository;

    public RoomDto calculateRoomPrice(Room room) {
        Price price = priceRepository.findById(1L).orElse(new Price());

        // ✅ مهم جدًا: لو السعر جديد أو الـ embeddeds null، نعمل init عشان الـ strategies ما تقعش
        ensureEmbeddedObjects(price);

        RoomDto dto = new RoomDto();
        dto.setArea(room.getArea() != null ? room.getArea() : 0.0);
        dto.setPerimeter(room.getPerimeter() != null ? room.getPerimeter() : 0.0);

        long total = 0;

        // ✅ العزل البارد (Safe من null)
        Long ci = price.getColdInsulationForFloors();
        long coldInsulation = (ci != null ? ci : 0L);

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

    /**
     * مهم لتفادي NullPointer داخل أي strategy لو الـ Price جديد (new Price()).
     * Price عندك فيه Embedded objects كتير (floorWallPrices / ceilingPrices / ...)،
     * فلازم تتعمل init لو null.
     */
    private void ensureEmbeddedObjects(Price price) {
        if (price.getFloorWallPrices() == null) price.setFloorWallPrices(new FloorWallPrices());
        if (price.getCeilingPrices() == null) price.setCeilingPrices(new CeilingPrices());
        if (price.getVentilationPrices() == null) price.setVentilationPrices(new VentilationPrices());
        if (price.getLightingPrices() == null) price.setLightingPrices(new LightingPrices());
        if (price.getDoorPrices() == null) price.setDoorPrices(new DoorPrices());
        if (price.getWindowPrices() == null) price.setWindowPrices(new WindowPrices());
        if (price.getShutterPrices() == null) price.setShutterPrices(new ShutterPrices());
        if (price.getBathroomPrices() == null) price.setBathroomPrices(new BathroomPrices());
    }

    private String buildFloorFormula(org.example.demo_11.eunms.floorwall.FloorMaterial material,
                                     Double area) {
        // الباركيه HDF و SPC بيضرب في 1.2
        boolean isParquet = material.name().contains("Parquet") &&
                (material.name().contains("HDF") || material.name().contains("SPC"));

        double baseArea = (area != null ? area : 0.0);
        double actualArea = isParquet ? baseArea * 1.2 : baseArea;

        if (isParquet) {
            return String.format("(مواد + عمالة) × %.2f م² × 1.2 (هالك باركيه) = السعر", baseArea);
        } else {
            return String.format("(مواد + عمالة) × %.2f م² = السعر", actualArea);
        }
    }

    private String buildWallFormula(org.example.demo_11.eunms.floorwall.WallType wallType,
                                    Double perimeter) {
        double p = (perimeter != null ? perimeter : 0.0);
        return String.format("(مواد + عمالة) × %.2f م (المحيط) × 3 م (الارتفاع) = السعر", p);
    }

    private String buildCeilingFormula(org.example.demo_11.eunms.ceiling.CeilingType ceilingType,
                                       Double area, Double perimeter) {
        double a = (area != null ? area : 0.0);
        double p = (perimeter != null ? perimeter : 0.0);

        switch (ceilingType) {
            case BEIT_NOOR:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + إضاءة خلفية LED = السعر", p);
            case SHADOW_GAP:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + باند 51 = السعر", p);
            case SHADOW_GAP_LIGHT:
                return String.format("(مواد + عمالة) × %.2f م + (باند 51 × %.2f م²) = السعر", p, a);
            case CORNICE_FUTEC_SMALL:
                return "كرانيش فيوتك صغير (مواد + عمالة) = السعر الثابت";
            case CORNICE_FUTEC_LARGE:
                return "كرانيش فيوتك كبير (مواد + عمالة) = السعر الثابت";
            case FLAT:
                return String.format("(مواد + عمالة) × %.2f م² = السعر", a);
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
//            case NONE:
//                return "لا يوجد شفاط - 0 جنيه";
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
