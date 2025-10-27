package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.KitchenDto;
import org.example.demo_11.model.Kitchen;
import org.example.demo_11.model.Price;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitchenPriceService {

    private final PriceRepository priceRepository;

    public KitchenDto calculateKitchenPrice(Kitchen kitchen) {
        Price price = priceRepository.findById(1L).orElse(new Price());

        KitchenDto dto = new KitchenDto();
        dto.setArea(kitchen.getArea());
        dto.setPerimeter(kitchen.getPerimeter());

        long total = 0;

        // ✅ أرضية
        Long floorPrice = 0L;
        String floorFormula = "";
        if (kitchen.getFloorWallMaterial() != null) {
            floorPrice = kitchen.getFloorWallMaterial()
                    .createStrategy(price, kitchen.getArea(), kitchen.getPerimeter())
                    .calculatePrice();

            // بناء المعادلة حسب نوع المادة
            floorFormula = buildFloorFormula(kitchen.getFloorWallMaterial(), price, kitchen.getArea());
        }
        dto.setPriceFloorMaterial(floorPrice);
        dto.setPriceFloorMaterialFormula(floorFormula);
        dto.setFloorMaterialSTR(kitchen.getFloorWallMaterial() != null ?
                kitchen.getFloorWallMaterial().getArabicName() : "");
        dto.setFloorMaterial(kitchen.getFloorWallMaterial());
        total += floorPrice;

        // ✅ الحوائط
        Long wallPrice = 0L;
        String wallFormula = "";
        if (kitchen.getWallType() != null) {
            wallPrice = kitchen.getWallType()
                    .createStrategy(price, kitchen.getArea(), kitchen.getPerimeter())
                    .calculatePrice();

            wallFormula = buildWallFormula(kitchen.getWallType(), price, kitchen.getPerimeter());
        }
        dto.setPriceWallMaterial(wallPrice);
        dto.setPriceWallMaterialFormula(wallFormula);
        dto.setWallMaterialSTR(kitchen.getWallType() != null ?
                kitchen.getWallType().getArabicName() : "");
        dto.setWallMaterial(kitchen.getWallType());
        total += wallPrice;

        // ✅ السقف
        Long ceilingPrice = 0L;
        String ceilingFormula = "";
        if (kitchen.getCeilingType() != null) {
            ceilingPrice = kitchen.getCeilingType()
                    .createStrategy(price)
                    .calculatePrice(kitchen.getArea(), kitchen.getPerimeter());

            ceilingFormula = buildCeilingFormula(kitchen.getCeilingType(), price,
                    kitchen.getArea(), kitchen.getPerimeter());
        }
        dto.setCeilingTypePrice(ceilingPrice);
        dto.setCeilingTypeFormula(ceilingFormula);
        dto.setCeilingTypeSTR(kitchen.getCeilingType() != null ?
                kitchen.getCeilingType().getNameAr() : "");
        total += ceilingPrice;

        // ✅ الشفاط
        Long exhaustPrice = 0L;
        String exhaustFormula = "";
        if (kitchen.getExhaustType() != null) {
            exhaustPrice = kitchen.getExhaustType()
                    .createStrategy(price)
                    .calculatePrice();

            exhaustFormula = buildExhaustFormula(kitchen.getExhaustType(), price);
        }
        dto.setPriceExhaust(exhaustPrice);
        dto.setPriceExhaustFormula(exhaustFormula);
        dto.setExhaustMaterialSTR(kitchen.getExhaustType() != null ?
                kitchen.getExhaustType().getArabicName() : "");
        dto.setExhaustType(kitchen.getExhaustType());
        total += exhaustPrice;

        // ✅ الحوض (Sink)
        Long sinkPrice = 0L;
        String sinkFormula = "";
        if (kitchen.getSinkType() != null) {
            sinkPrice = kitchen.getSinkType().calculatePrice(price);
            sinkFormula = buildSinkFormula(kitchen.getSinkType(), price);
        }
        dto.setAdaptationprice(sinkPrice);
        dto.setAdaptationPriceFormula(sinkFormula);
        total += sinkPrice;

        // باقي الأسعار
        Long coldInsulation = price != null ? price.getColdInsulationForFloors() : 0;
        dto.setFloorColdInsulation(coldInsulation);
        dto.setFloorColdInsulationFormula(coldInsulation + " جنيه (ثابت)");
        total += coldInsulation;

        Long plumbingSetup = price != null ? price.getPlumbingKitchenSetup() : 0;
        dto.setPlumbingKitchenSetup(plumbingSetup);
        dto.setPlumbingKitchenSetupFormula(plumbingSetup + " جنيه (ثابت)");
        total += plumbingSetup;

        Long plumbingFinnish = price != null ? price.getPlumbingKitchenFinnish() : 0;
        dto.setPlumbingKitchenFinnish(plumbingFinnish);
        dto.setPlumbingKitchenFinnishFormula(plumbingFinnish + " جنيه (ثابت)");
        total += plumbingFinnish;

        Long maharhPrice = price != null ?
                (long) (price.getMaharhBand38() * 3 * kitchen.getPerimeter()) : 0;
        dto.setMaharhBand38(maharhPrice);
        dto.setMaharhBand38Formula(String.format("%.2f × 3 × %.2f = %d جنيه",
                price != null ? price.getMaharhBand38() : 0.0,
                kitchen.getPerimeter(), maharhPrice));
        total += maharhPrice;

        dto.setTotalPrice(total);
        dto.setTotalPriceFormula(buildTotalFormula(dto));

        return dto;
    }

    private String buildFloorFormula(org.example.demo_11.eunms.floorwall.FloorMaterial material,
                                     Price price, Double area) {
        // حسب نوع المادة - الباركيه بيضرب في 1.2
        boolean isParquet = material.name().contains("Parquet") &&
                (material.name().contains("HDF") || material.name().contains("SPC"));

        double actualArea = isParquet ? area * 1.2 : area;

        return String.format("(مواد + عمالة) × %.2f م² = السعر", actualArea);
    }

    private String buildWallFormula(org.example.demo_11.eunms.floorwall.WallType wallType,
                                    Price price, Double perimeter) {
        return String.format("(مواد + عمالة) × %.2f م (المحيط) × 3 م (الارتفاع) = السعر",
                perimeter);
    }

    private String buildCeilingFormula(org.example.demo_11.eunms.ceiling.CeilingType ceilingType,
                                       Price price, Double area, Double perimeter) {
        switch (ceilingType) {
            case BEIT_NOOR:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + إضاءة خلفية LED",
                        perimeter);
            case SHADOW_GAP:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + باند 51",
                        perimeter);
            case SHADOW_GAP_LIGHT:
                return String.format("(مواد + عمالة) × %.2f م + (باند 51 × %.2f م²)",
                        perimeter, area);
            case CORNICE_FUTEC_SMALL:
            case CORNICE_FUTEC_LARGE:
                return "(مواد + عمالة) = السعر الثابت";

            // ✅ الحالة الجديدة للسقف المسطح (FLAT)
            case FLAT:
                return String.format("(مواد + عمالة) × %.2f م² (المساحة) = المساحة", area);

            default:
                return "غير محدد";
        }
    }

    private String buildExhaustFormula(org.example.demo_11.eunms.exhaust.ExhaustType exhaustType,
                                       Price price) {
        switch (exhaustType) {
            case WINDOW_EXHAUST:
                return "مواد شفاط شباك + عمالة تركيب";
            case CEILING_EXHAUST:
                return "مواد شفاط سقف + عمالة تركيب";
            case NONE:
                return "لا يوجد شفاط - 0 جنيه";
            default:
                return "غير محدد";
        }
    }

    private String buildSinkFormula(org.example.demo_11.eunms.sink.SinkType sinkType, Price price) {
        return String.format("مواد حوض %s + عمالة تركيب", sinkType.getArabicName());
    }

    private String buildTotalFormula(KitchenDto dto) {
        StringBuilder formula = new StringBuilder();
        formula.append("المجموع = ");

        if (dto.getPriceFloorMaterial() != null && dto.getPriceFloorMaterial() > 0) {
            formula.append("أرضية (").append(dto.getPriceFloorMaterial()).append(") + ");
        }
        if (dto.getPriceWallMaterial() != null && dto.getPriceWallMaterial() > 0) {
            formula.append("حوائط (").append(dto.getPriceWallMaterial()).append(") + ");
        }
        if (dto.getCeilingTypePrice() != null && dto.getCeilingTypePrice() > 0) {
            formula.append("سقف (").append(dto.getCeilingTypePrice()).append(") + ");
        }
        if (dto.getPriceExhaust() != null && dto.getPriceExhaust() > 0) {
            formula.append("شفاط (").append(dto.getPriceExhaust()).append(") + ");
        }
        if (dto.getAdaptationprice() != null && dto.getAdaptationprice() > 0) {
            formula.append("حوض (").append(dto.getAdaptationprice()).append(") + ");
        }
        if (dto.getFloorColdInsulation() != null && dto.getFloorColdInsulation() > 0) {
            formula.append("عزل (").append(dto.getFloorColdInsulation()).append(") + ");
        }
        if (dto.getPlumbingKitchenSetup() != null && dto.getPlumbingKitchenSetup() > 0) {
            formula.append("تأسيس (").append(dto.getPlumbingKitchenSetup()).append(") + ");
        }
        if (dto.getPlumbingKitchenFinnish() != null && dto.getPlumbingKitchenFinnish() > 0) {
            formula.append("فنش (").append(dto.getPlumbingKitchenFinnish()).append(") + ");
        }
        if (dto.getMaharhBand38() != null && dto.getMaharhBand38() > 0) {
            formula.append("محارة (").append(dto.getMaharhBand38()).append(") + ");
        }

        // إزالة آخر " + "
        if (formula.toString().endsWith(" + ")) {
            formula.setLength(formula.length() - 3);
        }

        formula.append(" = ").append(dto.getTotalPrice()).append(" جنيه");

        return formula.toString();
    }
}