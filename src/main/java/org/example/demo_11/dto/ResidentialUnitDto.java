package org.example.demo_11.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_11.eunms.UnitCollection;
import org.example.demo_11.eunms.FinishingStatus;
import org.example.demo_11.eunms.Location;
import org.example.demo_11.eunms.SPOT;
import org.example.demo_11.eunms.MAGNTIC_TRACK;
import org.example.demo_11.eunms.door.DoorType;
import org.example.demo_11.eunms.shutter.ShutterType;
import org.example.demo_11.eunms.window.WindowType;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        // المعلومات الأساسية
        "totalArea", "roomsNumber", "location", "unitCollection", "finishingStatus",

        // التكسير
        "previousFinishingDemolitionStr", "demolitionFormula", "previousFinishingDemolition",

        // الكهرباء
        "electricalInstallationStr", "electricalFormula", "electricalInstallation",

        // المواد الأساسية
        "cementAndMaterialSupplyStr", "cementMaterialFormula", "cementAndMaterialSupply",
        "cementSandAndMaterialsSupplyStr", "cementSandFormula", "cementSandAndMaterialsSupply",

        // الإضاءة
        "spotTypeStr", "spotFormula", "spotPrice",
        "magneticTrackTypeStr", "magneticTrackFormula", "magneticTrackPrice",

        // الأبواب
        "interiorDoorsStr", "interiorDoorsType", "interiorDoorsCount",
        "interiorDoorsFormula", "interiorDoorsPrice",
        "exteriorDoorsStr", "exteriorDoorsType",
        "exteriorDoorsFormula", "exteriorDoorsPrice",

        // الشاتر
        "shutterStr", "shutterTypes", "shutterCount",
        "shutterFormula", "shutterDetails", "shutterPrice",

        // النوافذ
        "windowsStr", "windowsType", "windowsCount",
        "windowsFormula", "windowsPrice",

        // الإجمالي
        "totalPrice"
})
public class ResidentialUnitDto {

    // === المعلومات الأساسية ===
    private Long totalArea;
    private int roomsNumber;
    private Location location;
    private UnitCollection unitCollection;
    private FinishingStatus finishingStatus;

    // === التكسير ===
    private String previousFinishingDemolitionStr = "تكسيـر التشطيب السابق";
    private String demolitionFormula; // 🆕
    private Long previousFinishingDemolition;

    // === الكهرباء ===
    private String electricalInstallationStr = "تأسيس الكهرباء";
    private String electricalFormula; // 🆕
    private Long electricalInstallation;

    // === المواد الأساسية ===
    private String cementAndMaterialSupplyStr = "توريدات أسمنت ومواد";
    private String cementMaterialFormula; // 🆕
    private Long cementAndMaterialSupply;

    private String cementSandAndMaterialsSupplyStr = "توريدات رمل وأسمنت وخامات أخرى وتشوينات";
    private String cementSandFormula; // 🆕
    private Long cementSandAndMaterialsSupply;

    // === الإضاءة ===
    private String spotTypeStr;
    private SPOT spotType;
    private String spotFormula; // 🆕
    private Long spotPrice;

    private String magneticTrackTypeStr;
    private MAGNTIC_TRACK magneticTrackType;
    private String magneticTrackFormula; // 🆕
    private Long magneticTrackPrice;

    // === الأبواب ===
    private String interiorDoorsStr = "الأبواب الداخلية";
    private DoorType interiorDoorsType;
    private int interiorDoorsCount;
    private String interiorDoorsFormula; // 🆕
    private Long interiorDoorsPrice;

    private String exteriorDoorsStr = "الباب الخارجي";
    private DoorType exteriorDoorsType;
    private String exteriorDoorsFormula; // 🆕
    private Long exteriorDoorsPrice;

    // === الشاتر ===
    private String shutterStr = "الشاتر";
    private List<ShutterType> shutterTypes;
    private Long shutterCount;
    private String shutterFormula; // 🆕
    private List<String> shutterDetails;
    private Long shutterPrice;

    // === النوافذ ===
    private String windowsStr = "النوافذ";
    private WindowType windowsType;
    private Long windowsCount;
    private String windowsFormula; // 🆕
    private Long windowsPrice;

    // === الإجمالي ===
    private Long totalPrice;
}