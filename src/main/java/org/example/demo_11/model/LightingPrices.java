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
public class LightingPrices {

    @Column(name = "spot_single_materials")
    @JsonProperty("spotSingleMaterials")
    private Long spotSingleMaterials;

    @Column(name = "spot_single_labor")
    @JsonProperty("spotSingleLabor")
    private Long spotSingleLabor;

    @Column(name = "spot_double_materials")
    @JsonProperty("spotDoubleMaterials")
    private Long spotDoubleMaterials;

    @Column(name = "spot_double_labor")
    @JsonProperty("spotDoubleLabor")
    private Long spotDoubleLabor;

    @Column(name = "spot15cm_materials")
    @JsonProperty("spot15cmMaterials")
    private Long spot15cmMaterials;

    @Column(name = "spot15cm_labor")
    @JsonProperty("spot15cmLabor")
    private Long spot15cmLabor;

    @Column(name = "spot25cm_materials")
    @JsonProperty("spot25cmMaterials")
    private Long spot25cmMaterials;

    @Column(name = "spot25cm_labor")
    @JsonProperty("spot25cmLabor")
    private Long spot25cmLabor;

    @Column(name = "chandelier_materials")
    @JsonProperty("chandelierMaterials")
    private Long chandelierMaterials;

    @Column(name = "chandelier_labor")
    @JsonProperty("chandelierLabor")
    private Long chandelierLabor;

    @Column(name = "back_led_hidden_lighting_materials")
    @JsonProperty("backLedHiddenLightingMaterials")
    private Long backLedHiddenLightingMaterials;

    @Column(name = "back_led_hidden_lighting_labor")
    @JsonProperty("backLedHiddenLightingLabor")
    private Long backLedHiddenLightingLabor;

    // ⚠️ تم حذف هذا الحقل لأنه مكرر وغير واضح
    // @Column(name = "back_led_hidden_lighting")
    // @JsonProperty("backLedHiddenLighting")
    // private Long backLedHiddenLighting;

    // ✅ توحيد التسمية: إما جميعها "magneticTrackLighting" أو "magneticTrack"
    @Column(name = "magnetic_track_lighting_materials")
    @JsonProperty("magneticTrackLightingMaterials")
    private Long magneticTrackLightingMaterials;

    @Column(name = "magnetic_track_lighting_labor")
    @JsonProperty("magneticTrackLightingLabor")
    private Long magneticTrackLightingLabor;

    // ⚠️ تم حذف هذه لأنها مكررة مع السابقة
    // @Column(name = "magnetic_track_materials")
    // @JsonProperty("magneticTrackMaterials")
    // private Long magneticTrackMaterials;

    // @Column(name = "magnetic_track_labor")
    // @JsonProperty("magneticTrackLabor")
    // private Long magneticTrackLabor;
}