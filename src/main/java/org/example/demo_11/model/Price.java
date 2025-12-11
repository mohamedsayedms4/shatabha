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

    @JsonProperty("maharhBand38")
    private Long maharhBand38;

    @JsonProperty("pathRoomAccesories")
    private Long pathRoomAccesories;

    @JsonProperty("plumbingPatRoomSetup")
    private Long plumbingPatRoomSetup;

    @JsonProperty("plumbingPatRoomFinnish")
    private Long plumbingPatRoomFinnish;

    @JsonProperty("plumbingKitchenSetup")
    private Long plumbingKitchenSetup;

    @JsonProperty("plumbingKitchenFinnish")
    private Long plumbingKitchenFinnish;

    @JsonProperty("paintForWallMaterials")
    private Long paintForWallMaterials;

    @JsonProperty("paintForWallLabor")
    private Long paintForWallLabor;

    @JsonProperty("paintForCeilingMaterials")
    private Long paintForCeilingMaterials;

    @JsonProperty("paintForCeilingLabor")
    private Long paintForCeilingLabor;

    @JsonProperty("previousFinishingDemolitionLessThan100M")
    private Long previousFinishingDemolitionLessThan100M;

    @JsonProperty("previousFinishingDemolitionLessThan150M")
    private Long previousFinishingDemolitionLessThan150M;

    @JsonProperty("previousFinishingDemolitionMoreThan150M")
    private Long previousFinishingDemolitionMoreThan150M;

    @JsonProperty("electricalInstallationLessThan100MCategory")
    private Long electricalInstallationLessThan100MCategory;

    @JsonProperty("electricalInstallationLessThan100MManufacturers")
    private Long electricalInstallationLessThan100MManufacturers;

    @JsonProperty("electricalInstallationLessThan150MCategory")
    private Long electricalInstallationLessThan150MCategory;

    @JsonProperty("electricalInstallationLessThan150MManufacturers")
    private Long electricalInstallationLessThan150MManufacturers;

    @JsonProperty("electricalInstallationMoreThan150MCategory")
    private Long electricalInstallationMoreThan150MCategory;

    @JsonProperty("electricalInstallationMoreThan150MManufacturers")
    private Long electricalInstallationMoreThan150MManufacturers;

    @JsonProperty("cementAndMaterialSupplyLessThan100M")
    private Long cementAndMaterialSupplyLessThan100M;

    @JsonProperty("cementAndMaterialSupplyLessThan150M")
    private Long cementAndMaterialSupplyLessThan150M;

    @JsonProperty("cementAndMaterialSupplyMoreThan150M")
    private Long cementAndMaterialSupplyMoreThan150M;

    @JsonProperty("cementSandAndMaterialsSupplyLessThan100M")
    private Long cementSandAndMaterialsSupplyLessThan100M;

    @JsonProperty("cementSandAndMaterialsSupplyLessThan150M")
    private Long cementSandAndMaterialsSupplyLessThan150M;

    @JsonProperty("cementSandAndMaterialsSupplyMoreThan150M")
    private Long cementSandAndMaterialsSupplyMoreThan150M;

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