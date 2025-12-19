package org.example.demo_11.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_11.eunms.BathFloorMaterial;
import org.example.demo_11.eunms.exhaust.ExhaustType;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "area",
        "perimeter",

        "floorColdInsulationSTR",
        "floorColdInsulation",
        "floorColdInsulationFormula",

        "plumbingKitchenSetupSTR",
        "plumbingKitchenSetup",
        "plumbingKitchenSetupFormula",

        "plumbingKitchenFinnishSTR",
        "plumbingKitchenFinnish",
        "plumbingKitchenFinnishFormula",

        "maharhBand38STR",
        "maharhBand38",
        "maharhBand38Formula",

        // ===== (جديد) خامة المطبخ المدمجة =====
        "priceKitchenMaterialSTR",
        "priceKitchenMaterial",
        "priceKitchenMaterialFormula",
        "kitchenMaterialSTR",
        "kitchenMaterial",

        "ceilingTypeSTR",
        "ceilingTypePrice",
        "ceilingTypeFormula",

        "exhaustMaterialSTR",
        "priceExhaust",
        "priceExhaustFormula",
        "exhaustType",

        "adaptationPriceSTR",
        "adaptationprice",
        "adaptationPriceFormula",

        "totalPriceSTR",
        "totalPrice",
        "totalPriceFormula"
})
public class KitchenDto {

    // معلومات المطبخ الأساسية
    private Double area;
    private Double perimeter;

    // عزل بارد
    private String floorColdInsulationSTR = "عزل بارد لزوم الارضيات";
    private Long floorColdInsulation;
    private String floorColdInsulationFormula;

    // تأسيس صحي
    private String plumbingKitchenSetupSTR = "تأسيس الصحي لزوم المطابخ";
    private Long plumbingKitchenSetup;
    private String plumbingKitchenSetupFormula;

    // فنش صحي
    private String plumbingKitchenFinnishSTR = "فنش الصحي لزوم المطابخ";
    private Long plumbingKitchenFinnish;
    private String plumbingKitchenFinnishFormula;

    // محارة
    private String maharhBand38STR = "أعمال المحارة";
    private Long maharhBand38;
    private String maharhBand38Formula;

    // ===== (جديد) خامة المطبخ (مُدمج) =====
    private String priceKitchenMaterialSTR = "سعر خامة المطبخ";
    private Long priceKitchenMaterial;
    private String priceKitchenMaterialFormula;
    private String kitchenMaterialSTR;
    private BathFloorMaterial kitchenMaterial;

    // السقف
    private String ceilingTypeSTR;
    private Long ceilingTypePrice;
    private String ceilingTypeFormula;

    // الشفاط
    private String exhaustMaterialSTR;
    private Long priceExhaust;
    private String priceExhaustFormula;
    private ExhaustType exhaustType;

    // أعمال تكيف/تعديل (كنت مستخدمها للحوض)
    private String adaptationPriceSTR = "أعمال تكيف المطبخ";
    private Long adaptationprice;
    private String adaptationPriceFormula;

    // الإجمالي
    private String totalPriceSTR = "إجمالي سعر المطبخ";
    private Long totalPrice;
    private String totalPriceFormula;
}
