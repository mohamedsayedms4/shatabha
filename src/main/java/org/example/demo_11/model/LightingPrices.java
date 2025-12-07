//============================================
// 5. LightingPrices
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
public class LightingPrices {
    private Long spotSingleMaterials;
    private Long spotSingleLabor;
    private Long spotDoubleMaterials;
    private Long spotDoubleLabor;
    private Long spot15cmMaterials;
    private Long spot15cmLabor;
    private Long spot25cmMaterials;
    private Long spot25cmLabor;
    private Long chandelierMaterials;
    private Long chandelierLabor;
    private Long backLedHiddenLightingMaterials;
    private Long backLedHiddenLightingLabor;
    private Long magneticTrackLightingMaterials;
    private Long magneticTrackLightingLabor;
    private Long backLedHiddenLighting;
    private Long magneticTrackMaterials;
    private Long magneticTrackLabor;
}
