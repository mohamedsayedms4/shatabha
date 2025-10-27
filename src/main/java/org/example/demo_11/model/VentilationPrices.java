package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentilationPrices {
    // ============ التهوية ============
    private Long windowExhaustMaterials;
    private Long windowExhaustLabor;
    private Long ceilingExhaustMaterials;
    private Long ceilingExhaustLabor;
}