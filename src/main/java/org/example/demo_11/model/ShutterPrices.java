package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShutterPrices {
    // ============ الشاتر ============
    private Long shutterProtectionMaterials;
    private Long shutterProtectionLabor;
    private Long shutterWeatherResistantMaterials;
    private Long shutterWeatherResistantLabor;
    private Long shutterAntiTheftMaterials;
    private Long shutterAntiTheftLabor;
}