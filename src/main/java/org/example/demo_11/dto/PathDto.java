package org.example.demo_11.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_11.eunms.BathFloorMaterial;
import org.example.demo_11.eunms.exhaust.ExhaustType;
import org.example.demo_11.eunms.sink.SinkType;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "area", "perimeter",

        // ===== تشطيب الحمام (مُدمج) =====
        "bathFloorMaterialSTR", "bathFloorMaterial",
        "bathFloorMaterialFormula", "priceBathFloorMaterial",

        // السقف
        "ceilingTypeSTR", "ceilingFormula", "ceilingType",

        // الخلاط
        "mixerTypeSTR", "mixerType", "mixerFormula", "priceMixer",

        // القاعدة
        "baseTypeSTR", "baseType", "baseFormula", "priceBase",

        // الحوض
        "sinkTypeSTR", "sinkType", "sinkFormula", "sinkPrice",

        // الشاور
        "showerAreaSTR", "showerFormula", "priceShowerArea",

        // الشفاط
        "exhaustMaterialSTR", "exhaustType", "exhaustFormula", "priceExhaust",

        // باقي الحسابات
        "floorColdInsulationStr", "floorColdInsulation", "floorColdInsulationFormula",
        "plumbingPatRoomSetupSTR", "plumbingPatRoomSetup", "plumbingSetupFormula",
        "plumbingPatRoomFinnishSTR", "plumbingPatRoomFinnish", "plumbingFinnishFormula",
        "maharhBand38STR", "maharhBand38", "maharhFormula",
        "paintForWall", "paintWallFormula",
        "paintForCeiling", "paintCeilingFormula",
        "pathRoomAccesories", "accessoriesFormula",

        "totalPrice"
})
public class PathDto {

    // الأساسيات
    private Double area;
    private Double perimeter;

    // ===== تشطيب الحمام (مُدمج) =====
    private String bathFloorMaterialSTR;
    private BathFloorMaterial bathFloorMaterial;
    private String bathFloorMaterialFormula;
    private Long priceBathFloorMaterial;

    // === السقف ===
    private String ceilingTypeSTR;
    private String ceilingFormula;
    private Long ceilingType;

    // === الخلاط ===
    private String mixerTypeSTR;
    private String mixerType;
    private String mixerFormula;
    private Long priceMixer;

    // === القاعدة ===
    private String baseTypeSTR;
    private String baseType;
    private String baseFormula;
    private Long priceBase;

    // === الحوض ===
    private String sinkTypeSTR;
    private SinkType sinkType;
    private String sinkFormula;
    private Long sinkPrice;

    // === منطقة الاستحمام ===
    private String showerAreaSTR;
    private String showerFormula;
    private Long priceShowerArea;

    // === الشفاط ===
    private String exhaustMaterialSTR;
    private ExhaustType exhaustType;
    private String exhaustFormula;
    private Long priceExhaust;

    // === الأعمال الثابتة ===
    private String floorColdInsulationStr = "عزل بارد لزوم الأرضيات";
    private String floorColdInsulationFormula;
    private Long floorColdInsulation;

    private String plumbingPatRoomSetupSTR = "تأسيس الصحي لزوم الحمامات";
    private String plumbingSetupFormula;
    private Long plumbingPatRoomSetup;

    private String plumbingPatRoomFinnishSTR = "فنش الصحي لزوم الحمامات";
    private String plumbingFinnishFormula;
    private Long plumbingPatRoomFinnish;

    private String maharhBand38STR = "أعمال المحارة";
    private String maharhFormula;
    private Long maharhBand38;

    private String paintWallFormula;
    private Long paintForWall;

    private String paintCeilingFormula;
    private Long paintForCeiling;

    private String accessoriesFormula;
    private Long pathRoomAccesories;

    // الإجمالي
    private Long totalPrice;
}
