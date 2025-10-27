package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoorPrices {
    // ============ الأبواب ============
    private Long customMadeDoorMaterials;
    private Long customMadeDoorLabor;
    private Long readyMadeDoorMaterials;
    private Long readyMadeDoorLabor;
    private Long armoredDoorMaterials;
    private Long armoredDoorLabor;
}