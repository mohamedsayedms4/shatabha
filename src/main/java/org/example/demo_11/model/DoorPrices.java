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

    /**
     * سعر مواد الأبواب المصنوعة حسب الطلب (بالريال)
     */
    @Column(name = "custom_made_door_materials")
    @JsonProperty("customMadeDoorMaterials")
    private Long customMadeDoorMaterials;

    /**
     * سعر عمالة تركيب الأبواب المصنوعة حسب الطلب (بالريال)
     */
    @Column(name = "custom_made_door_labor")
    @JsonProperty("customMadeDoorLabor")
    private Long customMadeDoorLabor;

    /**
     * سعر مواد الأبواب الجاهزة (بالريال)
     */
    @Column(name = "ready_made_door_materials")
    @JsonProperty("readyMadeDoorMaterials")
    private Long readyMadeDoorMaterials;

    /**
     * سعر عمالة تركيب الأبواب الجاهزة (بالريال)
     */
    @Column(name = "ready_made_door_labor")
    @JsonProperty("readyMadeDoorLabor")
    private Long readyMadeDoorLabor;

    /**
     * سعر مواد الأبواب المدرعة (بالريال)
     */
    @Column(name = "armored_door_materials")
    @JsonProperty("armoredDoorMaterials")
    private Long armoredDoorMaterials;

    /**
     * سعر عمالة تركيب الأبواب المدرعة (بالريال)
     */
    @Column(name = "armored_door_labor")
    @JsonProperty("armoredDoorLabor")
    private Long armoredDoorLabor;
}