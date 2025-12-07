// ============================================
// 4. DoorPrices
// ============================================
package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoorPrices {
    private Long customMadeDoorMaterials;
    private Long customMadeDoorLabor;
    private Long readyMadeDoorMaterials;
    private Long readyMadeDoorLabor;
    private Long armoredDoorMaterials;
    private Long armoredDoorLabor;
}
