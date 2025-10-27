package org.example.demo_11.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_11.eunms.exhaust.ExhaustType;
import org.example.demo_11.eunms.floorwall.FloorMaterial;
import org.example.demo_11.eunms.floorwall.WallType;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "area",
        "perimeter",

        "floorColdInsulationStr",
        "priceFloorColdInsulation",
        "priceFloorColdInsulationFormula",

        "floorMaterialSTR",
        "floorMaterial",
        "priceFloorMaterial",
        "priceFloorMaterialFormula",

        "wallMaterialSTR",
        "wallMaterial",
        "priceWallMaterial",
        "priceWallMaterialFormula",

        "ceilingTypeSTR",
        "ceilingTypePeice",
        "ceilingTypePeiceFormula",

        "exhaustMaterialSTR",
        "exhaustType",
        "priceExhaust",
        "priceExhaustFormula",

        "totalPrice",
        "totalPriceFormula"
})
public class RoomDto {

    // ✅ Dimensions
    private Double area;
    private Double perimeter;

    // ✅ Floor Cold Insulation
    private String floorColdInsulationStr = "عزل بارد لزوم الارضيات";
    private Long priceFloorColdInsulation;
    private String priceFloorColdInsulationFormula;

    // ✅ Floor Material
    private String floorMaterialSTR;
    private FloorMaterial floorMaterial;
    private Long priceFloorMaterial;
    private String priceFloorMaterialFormula;

    // ✅ Wall Material
    private String wallMaterialSTR;
    private WallType wallMaterial;
    private Long priceWallMaterial;
    private String priceWallMaterialFormula;

    // ✅ Ceiling
    private String ceilingTypeSTR;
    private Long ceilingTypePeice;
    private String ceilingTypePeiceFormula;

    // ✅ Exhaust
    private String exhaustMaterialSTR;
    private ExhaustType exhaustType;
    private Long priceExhaust;
    private String priceExhaustFormula;

    // ✅ Total
    private Long totalPrice;
    private String totalPriceFormula;
}