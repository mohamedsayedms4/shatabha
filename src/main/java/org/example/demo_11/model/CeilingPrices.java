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
public class CeilingPrices {

    @Column(name = "beit_noor_materials")
    @JsonProperty("beitNoorMaterials")
    private Long beitNoorMaterials;

    @Column(name = "beit_noor_labor")
    @JsonProperty("beitNoorLabor")
    private Long beitNoorLabor;

    @Column(name = "shadow_gap_materials")
    @JsonProperty("shadowGapMaterials")
    private Long shadowGapMaterials;

    @Column(name = "shadow_gap_labor")
    @JsonProperty("shadowGapLabor")
    private Long shadowGapLabor;

    @Column(name = "band51")
    @JsonProperty("band51")
    private Long band51;

    @Column(name = "shadow_gap_light_materials")
    @JsonProperty("shadowGapLightMaterials")
    private Long shadowGapLightMaterials;

    @Column(name = "shadow_gap_light_labor")
    @JsonProperty("shadowGapLightLabor")
    private Long shadowGapLightLabor;

    @Column(name = "cornice_futec_small_materials")
    @JsonProperty("corniceFutecSmallMaterials")
    private Long corniceFutecSmallMaterials;

    @Column(name = "cornice_futec_small_labor")
    @JsonProperty("corniceFutecSmallLabor")
    private Long corniceFutecSmallLabor;

    @Column(name = "cornice_futec_large_materials")
    @JsonProperty("corniceFutecLargeMaterials")
    private Long corniceFutecLargeMaterials;

    @Column(name = "cornice_futec_large_labor")
    @JsonProperty("corniceFutecLargeLabor")
    private Long corniceFutecLargeLabor;

    @Column(name = "flat_materials")
    @JsonProperty("flatMaterials")
    private Long flatMaterials;

    @Column(name = "flat_labor")
    @JsonProperty("flatLabor")
    private Long flatLabor;

    @Column(name = "celing_paint_normal_materials")
    @JsonProperty("celingPaint_NormalMaterials")
    private Long CelingPaint_NormalMaterials;

    @Column(name = "celing_paint_normal_labor")
    @JsonProperty("celingPaint_NormalLabor")
    private Long CelingPaint_NormalLabor;

    @Column(name = "celing_paint_stritch_materials")
    @JsonProperty("celingPaint_StritchMaterials")
    private Long CelingPaint_StritchMaterials;

    @Column(name = "celing_paint_stritch_labor")
    @JsonProperty("celingPaint_StritchLabor")
    private Long CelingPaint_StritchLabor;

    @Column(name = "celing_dicoar_qatifa_materials")
    @JsonProperty("celingDicoar_QatifaMaterials")
    private Long CelingDicoar_QatifaMaterials;

    @Column(name = "celing_dicoar_qatifa_labor")
    @JsonProperty("celingDicoar_QatifaLabor")
    private Long CelingDicoar_QatifaLabor;

    @Column(name = "celing_dicoar_tagalid_materials")
    @JsonProperty("celingDicoar_TagalidMaterials")
    private Long CelingDicoar_TagalidMaterials;

    @Column(name = "celing_dicoar_tagalid_labor")
    @JsonProperty("celingDicoar_TagalidLabor")
    private Long CelingDicoar_TagalidLabor;
}