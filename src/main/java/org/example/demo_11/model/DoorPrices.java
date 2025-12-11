package org.example.demo_11.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoorPrices {

    @Column(name = "custom_made_door_materials")
    @JsonProperty("customMadeDoorMaterials")
    private Long customMadeDoorMaterials;

    @Column(name = "custom_made_door_labor")
    @JsonProperty("customMadeDoorLabor")
    private Long customMadeDoorLabor;

    @Column(name = "ready_made_door_materials")
    @JsonProperty("readyMadeDoorMaterials")
    private Long readyMadeDoorMaterials;

    @Column(name = "ready_made_door_labor")
    @JsonProperty("readyMadeDoorLabor")
    private Long readyMadeDoorLabor;

    @Column(name = "armored_door_materials")
    @JsonProperty("armoredDoorMaterials")
    private Long armoredDoorMaterials;

    @Column(name = "armored_door_labor")
    @JsonProperty("armoredDoorLabor")
    private Long armoredDoorLabor;
}