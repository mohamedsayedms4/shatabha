
// ============================================
// 9. VentilationPrices
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
public class VentilationPrices {
    private Long windowExhaustMaterials;
    private Long windowExhaustLabor;
    private Long ceilingExhaustMaterials;
    private Long ceilingExhaustLabor;
}