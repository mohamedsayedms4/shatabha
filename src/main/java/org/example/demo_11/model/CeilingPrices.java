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

    // اقتراح: إضافة وصف إذا كان "band51" نوع سقف
    @Column(name = "band_51_materials")  // أو "ceiling_band_51"
    @JsonProperty("band51Materials")
    private Long band51Materials;

    @Column(name = "band_51_labor")
    @JsonProperty("band51Labor")
    private Long band51Labor;

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

    // تصحيح: إصلاح الإملاء وإزالة underscore من JSON
    @Column(name = "ceiling_paint_normal_materials")
    @JsonProperty("ceilingPaintNormalMaterials")
    private Long ceilingPaintNormalMaterials;

    @Column(name = "ceiling_paint_normal_labor")
    @JsonProperty("ceilingPaintNormalLabor")
    private Long ceilingPaintNormalLabor;

    // تصحيح: "Stritch" ربما تكون "Stretch" (سقف مشدود)
    @Column(name = "ceiling_paint_stretch_materials")
    @JsonProperty("ceilingPaintStretchMaterials")
    private Long ceilingPaintStretchMaterials;

    @Column(name = "ceiling_paint_stretch_labor")
    @JsonProperty("ceilingPaintStretchLabor")
    private Long ceilingPaintStretchLabor;

    @Column(name = "ceiling_dicoar_qatifa_materials")
    @JsonProperty("ceilingDicoarQatifaMaterials")
    private Long ceilingDicoarQatifaMaterials;

    @Column(name = "ceiling_dicoar_qatifa_labor")
    @JsonProperty("ceilingDicoarQatifaLabor")
    private Long ceilingDicoarQatifaLabor;

    @Column(name = "ceiling_dicoar_tagalid_materials")
    @JsonProperty("ceilingDicoarTagalidMaterials")
    private Long ceilingDicoarTagalidMaterials;

    @Column(name = "ceiling_dicoar_tagalid_labor")
    @JsonProperty("ceilingDicoarTagalidLabor")
    private Long ceilingDicoarTagalidLabor;
}