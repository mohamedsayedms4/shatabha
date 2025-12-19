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
        dto.setArea(kitchen.getArea() != null ? kitchen.getArea() : 0);
        dto.setPerimeter(kitchen.getPerimeter() != null ? kitchen.getPerimeter() : 0);

        long total = 0;

        // ===================== (NEW) Kitchen Material (Merged) =====================
        Long kitchenMaterialPrice = 0L;
        String kitchenMaterialFormula = "";
        if (kitchen.getKitchenMaterial() != null) {
            kitchenMaterialPrice = kitchen.getKitchenMaterial()
                    .calculatePrice(price, dto.getArea(), dto.getPerimeter());

            kitchenMaterialFormula = String.format(
                    "(مواد + عمالة) × المساحة (%.2f) + (مواد + عمالة) × المحيط (%.2f) × 3",
                    dto.getArea(), dto.getPerimeter()
            );
        }

        dto.setPriceKitchenMaterial(kitchenMaterialPrice);
        dto.setPriceKitchenMaterialFormula(kitchenMaterialFormula);
        dto.setKitchenMaterialSTR(kitchen.getKitchenMaterial() != null ?
                kitchen.getKitchenMaterial().getArabicName() : "");
        dto.setKitchenMaterial(kitchen.getKitchenMaterial());

        total += kitchenMaterialPrice;

        // ===================== Ceiling =====================
        Long ceilingPrice = 0L;
        String ceilingFormula = "";
        if (kitchen.getCeilingType() != null) {
            ceilingPrice = kitchen.getCeilingType()
                    .createStrategy(price)
                    .calculatePrice(dto.getArea(), dto.getPerimeter());

            ceilingFormula = buildCeilingFormula(kitchen.getCeilingType(), price,
                    dto.getArea(), dto.getPerimeter());
        }
        dto.setCeilingTypePrice(ceilingPrice);
        dto.setCeilingTypeFormula(ceilingFormula);
        dto.setCeilingTypeSTR(kitchen.getCeilingType() != null ?
                kitchen.getCeilingType().getNameAr() : "");
        total += ceilingPrice;

        // ===================== Exhaust =====================
        Long exhaustPrice = 0L;
        String exhaustFormula = "";
        if (kitchen.getExhaustType() != null) {
            exhaustPrice = kitchen.getExhaustType()
                    .createStrategy(price)
                    .calculatePrice();

            exhaustFormula = buildExhaustFormula(kitchen.getExhaustType());
        }
        dto.setPriceExhaust(exhaustPrice);
        dto.setPriceExhaustFormula(exhaustFormula);
        dto.setExhaustMaterialSTR(kitchen.getExhaustType() != null ?
                kitchen.getExhaustType().getArabicName() : "");
        dto.setExhaustType(kitchen.getExhaustType());
        total += exhaustPrice;

        // ===================== Sink / Adaptation =====================
        Long sinkPrice = 0L;
        String sinkFormula = "";
        if (kitchen.getSinkType() != null) {
            sinkPrice = kitchen.getSinkType().calculatePrice(price);
            sinkFormula = String.format("مواد حوض %s + عمالة تركيب", kitchen.getSinkType().getArabicName());
        }
        dto.setAdaptationprice(sinkPrice);
        dto.setAdaptationPriceFormula(sinkFormula);
        total += sinkPrice;

        // ===================== Fixed Items =====================
        Long coldInsulation = price != null ? price.getColdInsulationForFloors() : 0;
        dto.setFloorColdInsulation(coldInsulation);
        dto.setFloorColdInsulationFormula(coldInsulation + " جنيه (ثابت)");
        total += coldInsulation;

        Long plumbingSetup = price != null ? price.getPlumbingKitchenSetup() : 0;
        dto.setPlumbingKitchenSetup(plumbingSetup);
        dto.setPlumbingKitchenSetupFormula(plumbingSetup + " جنيه (ثابت)");
        total += plumbingSetup;

        Long plumbingFinish = price != null ? price.getPlumbingKitchenFinish() : 0;
        dto.setPlumbingKitchenFinnish(plumbingFinish);
        dto.setPlumbingKitchenFinnishFormula(plumbingFinish + " جنيه (ثابت)");
        total += plumbingFinish;

        Long mahrhaPrice = price != null ?
                (long) (price.getMahrhaBand38() * 3 * dto.getPerimeter()) : 0;
        dto.setMaharhBand38(mahrhaPrice);
        dto.setMaharhBand38Formula(String.format("%.2f × 3 × %.2f = %d جنيه",
                price != null ? price.getMahrhaBand38() : 0.0,
                dto.getPerimeter(), mahrhaPrice));
        total += mahrhaPrice;

        dto.setTotalPrice(total);
        dto.setTotalPriceFormula(buildTotalFormula(dto));

        return dto;
    }

    private String buildCeilingFormula(org.example.demo_11.eunms.ceiling.CeilingType ceilingType,
                                       Price price, Double area, Double perimeter) {
        switch (ceilingType) {
            case BEIT_NOOR:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + إضاءة خلفية LED", perimeter);
            case SHADOW_GAP:
                return String.format("(مواد + عمالة) × %.2f م (المحيط) + باند 51", perimeter);
            case SHADOW_GAP_LIGHT:
                return String.format("(مواد + عمالة) × %.2f م + (باند 51 × %.2f م²)", perimeter, area);
            case CORNICE_FUTEC_SMALL:
            case CORNICE_FUTEC_LARGE:
                return "(مواد + عمالة) = السعر الثابت";
            case FLAT:
                return String.format("(مواد + عمالة) × %.2f م² (المساحة) = السعر", area);
            default:
                return "غير محدد";
        }
    }

    private String buildExhaustFormula(org.example.demo_11.eunms.exhaust.ExhaustType exhaustType) {
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

    private String buildTotalFormula(KitchenDto dto) {
        StringBuilder formula = new StringBuilder();
        formula.append("المجموع = ");

        if (dto.getPriceKitchenMaterial() != null && dto.getPriceKitchenMaterial() > 0) {
            formula.append("خامة (").append(dto.getPriceKitchenMaterial()).append(") + ");
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

        if (formula.toString().endsWith(" + ")) {
            formula.setLength(formula.length() - 3);
        }

        formula.append(" = ").append(dto.getTotalPrice()).append(" جنيه");
        return formula.toString();
    }
}
