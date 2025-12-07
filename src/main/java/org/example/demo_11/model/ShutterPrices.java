// ============================================
// 3. ShutterPrices
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
public class ShutterPrices {
    private Long shutterProtectionMaterials;
    private Long shutterProtectionLabor;
    private Long shutterWeatherResistantMaterials;
    private Long shutterWeatherResistantLabor;
    private Long shutterAntiTheftMaterials;
    private Long shutterAntiTheftLabor;
}
