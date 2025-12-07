package org.example.demo_11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {

    @Id
    private Long id = 1L;

    private Long coldInsulationForFloors;
    private Long maharhBand38;
    private Long pathRoomAccesories;
    private Long plumbingPatRoomSetup;
    private Long plumbingPatRoomFinnish;
    private Long plumbingKitchenSetup;
    private Long plumbingKitchenFinnish;
    private Long paintForWallMaterials;
    private Long paintForWallLabor;
    private Long paintForCeilingMaterials;
    private Long paintForCeilingLabor;
    private Long previousFinishingDemolitionLessThan100M;
    private Long previousFinishingDemolitionLessThan150M;
    private Long previousFinishingDemolitionMoreThan150M;
    private Long electricalInstallationLessThan100MCategory;
    private Long electricalInstallationLessThan100MManufacturers;
    private Long electricalInstallationLessThan150MCategory;
    private Long electricalInstallationLessThan150MManufacturers;
    private Long electricalInstallationMoreThan150MCategory;
    private Long electricalInstallationMoreThan150MManufacturers;
    private Long cementAndMaterialSupplyLessThan100M;
    private Long cementAndMaterialSupplyLessThan150M;
    private Long cementAndMaterialSupplyMoreThan150M;
    private Long cementSandAndMaterialsSupplyLessThan100M;
    private Long cementSandAndMaterialsSupplyLessThan150M;
    private Long cementSandAndMaterialsSupplyMoreThan150M;
    private Long adaptationMaterials;
    private Long adaptationLabor;

    @Embedded
    private WindowPrices windowPrices;

    @Embedded
    private ShutterPrices shutterPrices;

    @Embedded
    private DoorPrices doorPrices;

    @Embedded
    private LightingPrices lightingPrices;

    @Embedded
    private BathroomPrices bathroomPrices;

    @Embedded
    private FloorWallPrices floorWallPrices;

    @Embedded
    private CeilingPrices ceilingPrices;

    @Embedded
    private VentilationPrices ventilationPrices;
}