package org.example.demo_11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Price {

    @Id
    private Long id = 1L;

    @JsonProperty("coldInsulationForFloors")
    private Long coldInsulationForFloors;

    @JsonProperty("mahrhaBand38")  // تصحيح: maharh → mahrha
    private Long mahrhaBand38;

    @JsonProperty("bathRoomAccessories")  // تصحيح: path → bath, Accesories → Accessories
    private Long bathRoomAccessories;

    @JsonProperty("plumbingBathRoomSetup")  // تصحيح: pat → bath
    private Long plumbingBathRoomSetup;

    @JsonProperty("plumbingBathRoomFinish")  // تصحيح: pat → bath, Finnish → Finish
    private Long plumbingBathRoomFinish;

    @JsonProperty("plumbingKitchenSetup")
    private Long plumbingKitchenSetup;

    @JsonProperty("plumbingKitchenFinish")  // تصحيح: Finnish → Finish
    private Long plumbingKitchenFinish;

    @JsonProperty("paintForWallMaterials")
    private Long paintForWallMaterials;

    @JsonProperty("paintForWallLabor")
    private Long paintForWallLabor;

    @JsonProperty("paintForCeilingMaterials")
    private Long paintForCeilingMaterials;

    @JsonProperty("paintForCeilingLabor")
    private Long paintForCeilingLabor;

    @JsonProperty("previousFinishingDemolitionLessThan100Sqm")  // تصحيح: M → Sqm
    private Long previousFinishingDemolitionLessThan100Sqm;

    @JsonProperty("previousFinishingDemolitionLessThan150Sqm")  // تصحيح: M → Sqm
    private Long previousFinishingDemolitionLessThan150Sqm;

    @JsonProperty("previousFinishingDemolitionMoreThan150Sqm")  // تصحيح: M → Sqm
    private Long previousFinishingDemolitionMoreThan150Sqm;

    @JsonProperty("electricalInstallationLessThan100SqmCategory")  // تصحيح: M → Sqm
    private Long electricalInstallationLessThan100SqmCategory;

    @JsonProperty("electricalInstallationLessThan100SqmManufacturers")  // تصحيح: M → Sqm
    private Long electricalInstallationLessThan100SqmManufacturers;

    @JsonProperty("electricalInstallationLessThan150SqmCategory")  // تصحيح: M → Sqm
    private Long electricalInstallationLessThan150SqmCategory;

    @JsonProperty("electricalInstallationLessThan150SqmManufacturers")  // تصحيح: M → Sqm
    private Long electricalInstallationLessThan150SqmManufacturers;

    @JsonProperty("electricalInstallationMoreThan150SqmCategory")  // تصحيح: M → Sqm
    private Long electricalInstallationMoreThan150SqmCategory;

    @JsonProperty("electricalInstallationMoreThan150SqmManufacturers")  // تصحيح: M → Sqm
    private Long electricalInstallationMoreThan150SqmManufacturers;

    @JsonProperty("cementAndMaterialSupplyLessThan100Sqm")  // تصحيح: M → Sqm
    private Long cementAndMaterialSupplyLessThan100Sqm;

    @JsonProperty("cementAndMaterialSupplyLessThan150Sqm")  // تصحيح: M → Sqm
    private Long cementAndMaterialSupplyLessThan150Sqm;

    @JsonProperty("cementAndMaterialSupplyMoreThan150Sqm")  // تصحيح: M → Sqm
    private Long cementAndMaterialSupplyMoreThan150Sqm;

    @JsonProperty("cementSandAndMaterialsSupplyLessThan100Sqm")  // تصحيح: M → Sqm
    private Long cementSandAndMaterialsSupplyLessThan100Sqm;

    @JsonProperty("cementSandAndMaterialsSupplyLessThan150Sqm")  // تصحيح: M → Sqm
    private Long cementSandAndMaterialsSupplyLessThan150Sqm;

    @JsonProperty("cementSandAndMaterialsSupplyMoreThan150Sqm")  // تصحيح: M → Sqm
    private Long cementSandAndMaterialsSupplyMoreThan150Sqm;

    @JsonProperty("adaptationMaterials")
    private Long adaptationMaterials;

    @JsonProperty("adaptationLabor")
    private Long adaptationLabor;

    /* ===================== Bathroom Combined Floor/Wall Materials ===================== */
    // الفكرة: (material + labor) تُستخدم مع area + perimeter*3 داخل BathFloorMaterial

    // ===== Porcelain - Local =====
    @JsonProperty("bathLocalPorcelain60x120Material")
    private Long bathLocalPorcelain60x120Material;

    @JsonProperty("bathLocalPorcelain60x120Labor")
    private Long bathLocalPorcelain60x120Labor;

    // ===== Ceramic - Local =====
    @JsonProperty("bathLocalCeramic60x60Material")
    private Long bathLocalCeramic60x60Material;

    @JsonProperty("bathLocalCeramic60x60Labor")
    private Long bathLocalCeramic60x60Labor;

    @JsonProperty("bathLocalCeramic60x120Material")
    private Long bathLocalCeramic60x120Material;

    @JsonProperty("bathLocalCeramic60x120Labor")
    private Long bathLocalCeramic60x120Labor;

    // ===== Porcelain - Hindi Imported =====
    @JsonProperty("bathHindiPorcelain75x75Material")
    private Long bathHindiPorcelain75x75Material;

    @JsonProperty("bathHindiPorcelain75x75Labor")
    private Long bathHindiPorcelain75x75Labor;

    @JsonProperty("bathHindiPorcelain120x60Material")
    private Long bathHindiPorcelain120x60Material;

    @JsonProperty("bathHindiPorcelain120x60Labor")
    private Long bathHindiPorcelain120x60Labor;

    @JsonProperty("bathHindiPorcelain120x180Material")
    private Long bathHindiPorcelain120x180Material;

    @JsonProperty("bathHindiPorcelain120x180Labor")
    private Long bathHindiPorcelain120x180Labor;

    @JsonProperty("bathHindiPorcelain120x240Material")
    private Long bathHindiPorcelain120x240Material;

    @JsonProperty("bathHindiPorcelain120x240Labor")
    private Long bathHindiPorcelain120x240Labor;

    // ===== Porcelain - Spanish Imported =====
    @JsonProperty("bathSpanishPorcelain60x170Material")
    private Long bathSpanishPorcelain60x170Material;

    @JsonProperty("bathSpanishPorcelain60x170Labor")
    private Long bathSpanishPorcelain60x170Labor;

    @JsonProperty("bathSpanishPorcelain120x180Material")
    private Long bathSpanishPorcelain120x180Material;

    @JsonProperty("bathSpanishPorcelain120x180Labor")
    private Long bathSpanishPorcelain120x180Labor;

    @JsonProperty("bathSpanishPorcelain120x240Material")
    private Long bathSpanishPorcelain120x240Material;

    @JsonProperty("bathSpanishPorcelain120x240Labor")
    private Long bathSpanishPorcelain120x240Labor;

    // ===== Marble =====
    @JsonProperty("bathMarbleType1Material")
    private Long bathMarbleType1Material;

    @JsonProperty("bathMarbleType1Labor")
    private Long bathMarbleType1Labor;

    @JsonProperty("bathMarbleType2Material")
    private Long bathMarbleType2Material;

    @JsonProperty("bathMarbleType2Labor")
    private Long bathMarbleType2Labor;

    @JsonProperty("bathMarbleType3Material")
    private Long bathMarbleType3Material;

    @JsonProperty("bathMarbleType3Labor")
    private Long bathMarbleType3Labor;

    @JsonProperty("bathMarbleType4Material")
    private Long bathMarbleType4Material;

    @JsonProperty("bathMarbleType4Labor")
    private Long bathMarbleType4Labor;

    @Embedded
    @JsonProperty("windowPrices")
    private WindowPrices windowPrices;

    @Embedded
    @JsonProperty("shutterPrices")
    private ShutterPrices shutterPrices;

    @Embedded
    @JsonProperty("doorPrices")
    private DoorPrices doorPrices;

    @Embedded
    @JsonProperty("lightingPrices")
    private LightingPrices lightingPrices;

    @Embedded
    @JsonProperty("bathroomPrices")
    private BathroomPrices bathroomPrices;

    @Embedded
    @JsonProperty("floorWallPrices")
    private FloorWallPrices floorWallPrices;

    @Embedded
    @JsonProperty("ceilingPrices")
    private CeilingPrices ceilingPrices;

    @Embedded
    @JsonProperty("ventilationPrices")
    private VentilationPrices ventilationPrices;
}