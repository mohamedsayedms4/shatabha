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