package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.PathDto;
import org.example.demo_11.model.PathRoom;
import org.example.demo_11.model.Price;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathRoomPriceService {

    private final PriceRepository priceRepository;

    public PathDto calculatePathRoomPrice(PathRoom pathRoom) {
        Price price = priceRepository.findById(1L).orElse(new Price());

        PathDto dto = new PathDto();
        dto.setArea(pathRoom.getArea() != null ? pathRoom.getArea() : 0);
        dto.setPerimeter(pathRoom.getPerimeter() != null ? pathRoom.getPerimeter() : 0);

        long total = 0;

        if (pathRoom.getFloorWallMaterial() != null) {
            long floorPrice = pathRoom.getFloorWallMaterial()
                    .createStrategy(price, dto.getArea(), dto.getPerimeter())
                    .calculatePrice();
            dto.setPriceFloorMaterial(floorPrice);
            dto.setFloorMaterialSTR(pathRoom.getFloorWallMaterial().getArabicName());
            dto.setFloorMaterial(pathRoom.getFloorWallMaterial());

            dto.setFloorMaterialFormula(getFloorFormula(pathRoom.getFloorWallMaterial(), price, dto.getArea()));
            total += floorPrice;
        }

        if (pathRoom.getWallType() != null) {
            long wallPrice = pathRoom.getWallType()
                    .createStrategy(price, dto.getArea(), dto.getPerimeter())
                    .calculatePrice();
            dto.setPriceWallMaterial(wallPrice);
            dto.setWallMaterialSTR(pathRoom.getWallType().getArabicName());
            dto.setWallMaterial(pathRoom.getWallType());

            dto.setWallMaterialFormula(getWallFormula(pathRoom.getWallType(), price, dto.getPerimeter()));
            total += wallPrice;
        }

        if (pathRoom.getCeilingType() != null) {
            long ceilingPrice = pathRoom.getCeilingType()
                    .createStrategy(price)
                    .calculatePrice(dto.getArea(), dto.getPerimeter());
            dto.setCeilingType(ceilingPrice);
            dto.setCeilingTypeSTR(pathRoom.getCeilingType().getNameAr());

            dto.setCeilingFormula(getCeilingFormula(pathRoom.getCeilingType(), price, dto.getArea(), dto.getPerimeter()));
            total += ceilingPrice;
        }

        if (pathRoom.getExhaustType() != null) {
            long exhaustPrice = pathRoom.getExhaustType()
                    .createStrategy(price)
                    .calculatePrice();
            dto.setPriceExhaust(exhaustPrice);
            dto.setExhaustMaterialSTR(pathRoom.getExhaustType().getArabicName());
            dto.setExhaustType(pathRoom.getExhaustType());

            dto.setExhaustFormula(getExhaustFormula(pathRoom.getExhaustType(), price));
            total += exhaustPrice;
        }

        if (pathRoom.getMixerType() != null) {
            long mixerPrice = pathRoom.getMixerType()
                    .createStrategy(price)
                    .calculatePrice();
            dto.setPriceMixer(mixerPrice);
            dto.setMixerTypeSTR(pathRoom.getMixerType().getArabicName());
            dto.setMixerType(pathRoom.getMixerType().toString());

            dto.setMixerFormula(getMixerFormula(pathRoom.getMixerType(), price));
            total += mixerPrice;
        }

        if (pathRoom.getBaseType() != null) {
            long basePrice = pathRoom.getBaseType()
                    .createStrategy(price)
                    .calculatePrice();
            dto.setPriceBase(basePrice);
            dto.setBaseTypeSTR(pathRoom.getBaseType().getArabicName());
            dto.setBaseType(pathRoom.getBaseType().toString());

            dto.setBaseFormula(getBaseFormula(pathRoom.getBaseType(), price));
            total += basePrice;
        }

        if (pathRoom.getShowerArea() != null) {
            long showerPrice = pathRoom.getShowerArea()
                    .createStrategy(price)
                    .calculatePrice();
            dto.setPriceShowerArea(showerPrice);
            dto.setShowerAreaSTR(pathRoom.getShowerArea().getArabicName());

            dto.setShowerFormula(getShowerFormula(pathRoom.getShowerArea(), price));
            total += showerPrice;
        }

        if (pathRoom.getSinkType() != null) {
            long sinkPrice = pathRoom.getSinkType().calculatePrice(price);
            dto.setSinkPrice(sinkPrice);
            dto.setSinkTypeSTR(pathRoom.getSinkType().getArabicName());
            dto.setSinkType(pathRoom.getSinkType());

            dto.setSinkFormula(getSinkFormula(pathRoom.getSinkType(), price));
            total += sinkPrice;
        }

        long floorColdInsulation = price != null ? price.getColdInsulationForFloors() : 0;
        dto.setFloorColdInsulation(floorColdInsulation);
        dto.setFloorColdInsulationFormula("قيمة ثابتة: " + floorColdInsulation);
        total += floorColdInsulation;

        long plumbingSetup = price != null ? price.getPlumbingBathRoomSetup() : 0;
        dto.setPlumbingPatRoomSetup(plumbingSetup);
        dto.setPlumbingSetupFormula("قيمة ثابتة: " + plumbingSetup);
        total += plumbingSetup;

        long plumbingFinish = price != null ? price.getPlumbingBathRoomFinish() : 0;
        dto.setPlumbingPatRoomFinnish(plumbingFinish);
        dto.setPlumbingFinnishFormula("قيمة ثابتة: " + plumbingFinish);
        total += plumbingFinish;

        long mahrhaPrice = dto.getPerimeter() > 0 ? (long) (price.getMahrhaBand38() * 3 * dto.getPerimeter()) : 0;
        dto.setMaharhBand38(mahrhaPrice);
        dto.setMaharhFormula(String.format("سعر المتر (%d) × 3 × المحيط (%.2f) = %d",
                price.getMahrhaBand38(), dto.getPerimeter(), mahrhaPrice));
        total += mahrhaPrice;

        calculatePaintingPrices(dto, price);
        total += dto.getPaintForWall() != null ? dto.getPaintForWall() : 0;
        total += dto.getPaintForCeiling() != null ? dto.getPaintForCeiling() : 0;

        long accessories = price != null ? price.getBathRoomAccessories() : 0;
        dto.setPathRoomAccesories(accessories);
        dto.setAccessoriesFormula("قيمة ثابتة: " + accessories);
        total += accessories;

        dto.setTotalPrice(total);
        return dto;
    }

    private void calculatePaintingPrices(PathDto dto, Price price) {
        long area = dto.getArea().longValue();
        long perimeter = dto.getPerimeter().longValue();

        double wallPaint = (price.getPaintForWallMaterials() + price.getPaintForWallLabor()) * perimeter * 2.7;
        long wallPaintPrice = (long) wallPaint;
        dto.setPaintForWall(wallPaintPrice);
        dto.setPaintWallFormula(String.format("(مواد %d + عمالة %d) × المحيط %d × 2.7 = %d",
                price.getPaintForWallMaterials(), price.getPaintForWallLabor(), perimeter, wallPaintPrice));

        double ceilingPaint = (price.getPaintForCeilingMaterials() + price.getPaintForCeilingLabor()) * area;
        long ceilingPaintPrice = (long) ceilingPaint;
        dto.setPaintForCeiling(ceilingPaintPrice);
        dto.setPaintCeilingFormula(String.format("(مواد %d + عمالة %d) × المساحة %d = %d",
                price.getPaintForCeilingMaterials(), price.getPaintForCeilingLabor(), area, ceilingPaintPrice));
    }

    private String getFloorFormula(Object floorType, Price price, Double area) {
        String typeName = floorType.toString();

        if (typeName.contains("Parquet") && (typeName.contains("HDF") || typeName.contains("SPC"))) {
            return String.format("(مواد + عمالة) × المساحة × 1.2 = (مواد + عمالة) × %.2f × 1.2", area);
        }

        return String.format("(مواد + عمالة) × المساحة = (مواد + عمالة) × %.2f", area);
    }

    private String getWallFormula(Object wallType, Price price, Double perimeter) {
        return String.format("(مواد + عمالة) × المحيط × 3 = (مواد + عمالة) × %.2f × 3", perimeter);
    }

    private String getCeilingFormula(Object ceilingType, Price price, Double area, Double perimeter) {
        String typeName = ceilingType.toString();

        switch (typeName) {
            case "BEIT_NOOR":
                Long backLedMaterials = price.getLightingPrices().getBackLedHiddenLightingMaterials();
                Long backLedLabor = price.getLightingPrices().getBackLedHiddenLightingLabor();
                Long backLedPrice = safeAdd(backLedMaterials, backLedLabor);
                return String.format("(مواد + عمالة) × المحيط + إضاءة خلفية = (مواد + عمالة) × %.2f + %d",
                        perimeter, backLedPrice);

            case "SHADOW_GAP":
                Long band51Materials = price.getCeilingPrices().getBand51Materials();
                Long band51Labor = price.getCeilingPrices().getBand51Labor();
                Long band51Price = safeAdd(band51Materials, band51Labor);
                return String.format("(مواد + عمالة) × المحيط + باند 51 = (مواد + عمالة) × %.2f + %d",
                        perimeter, band51Price);

            case "SHADOW_GAP_LIGHT":
                Long band51Materials2 = price.getCeilingPrices().getBand51Materials();
                Long band51Labor2 = price.getCeilingPrices().getBand51Labor();
                Long band51Price2 = safeAdd(band51Materials2, band51Labor2);
                return String.format("(مواد + عمالة) × المحيط + (المساحة × باند 51) = (مواد + عمالة) × %.2f + (%.2f × %d)",
                        perimeter, area, band51Price2);

            case "FLAT":
                Long flatMaterials = price.getCeilingPrices().getFlatMaterials();
                Long flatLabor = price.getCeilingPrices().getFlatLabor();
                Long flatPrice = safeAdd(flatMaterials, flatLabor);
                return String.format("(مواد + عمالة) × المساحة = (%d + %d) × %.2f = %d × %.2f",
                        flatMaterials, flatLabor, area, flatPrice, area);

            default:
                return "مواد + عمالة";
        }
    }

    private String getExhaustFormula(Object exhaustType, Price price) {
        String typeName = exhaustType.toString();

        if (typeName.equals("NONE")) {
            return "لا يوجد شفاط = 0";
        }

        return "مواد + عمالة";
    }

    private String getMixerFormula(Object mixerType, Price price) {
        String typeName = mixerType.toString();

        if (typeName.contains("CONCEALED") || typeName.contains("HANGING")) {
            return "مواد الخلاط + عمالة الخلاط + مواد التركيب + عمالة التركيب";
        }

        return "مواد + عمالة";
    }

    private String getBaseFormula(Object baseType, Price price) {
        String typeName = baseType.toString();

        if (typeName.equals("WALL_HUNG_CONCEALED")) {
            return "مواد القاعدة + عمالة القاعدة + مواد الصندوق + عمالة الصندوق";
        }

        return "مواد + عمالة";
    }

    private String getShowerFormula(Object showerArea, Price price) {
        String typeName = showerArea.toString();

        switch (typeName) {
            case "SHOWER_BASE":
                return "مواد القدم + عمالة القدم + مواد الزجاج + عمالة الزجاج";
            case "NONE":
                return "بدون منطقة استحمام = مواد + عمالة";
            default:
                return "مواد + عمالة";
        }
    }

    private String getSinkFormula(Object sinkType, Price price) {
        return "مواد + عمالة";
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}