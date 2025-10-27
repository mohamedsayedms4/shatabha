package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CeilingPrices {
    // ============ الأسقف ============
    private Long beitNoorMaterials;
    private Long beitNoorLabor;
    private Long shadowGapMaterials;
    private Long shadowGapLabor;
    private Long band51;
    private Long shadowGapLightMaterials;
    private Long shadowGapLightLabor;
    private Long corniceFutecSmallMaterials;
    private Long corniceFutecSmallLabor;
    private Long corniceFutecLargeMaterials;
    private Long corniceFutecLargeLabor;
    private Long flatMaterials;
    private Long flatLabor;

    // ============ دهان الأسقف ============
    private Long CelingPaint_NormalMaterials;
    private Long CelingPaint_NormalLabor;
    private Long CelingPaint_StritchMaterials;
    private Long CelingPaint_StritchLabor;
    private Long CelingDicoar_QatifaMaterials;
    private Long CelingDicoar_QatifaLabor;
    private Long CelingDicoar_TagalidMaterials;
    private Long CelingDicoar_TagalidLabor;
}