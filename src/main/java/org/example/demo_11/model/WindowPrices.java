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
public class WindowPrices {

    @Column(name = "alumetal_ps_materials")
    @JsonProperty("alumetalPsMaterials")
    private Long alumetalPsMaterials;

    @Column(name = "alumetal_ps_labor")
    @JsonProperty("alumetalPsLabor")
    private Long alumetalPsLabor;

    @Column(name = "alumetal_jumpo_materials")
    @JsonProperty("alumetalJumpoMaterials")
    private Long alumetalJumpoMaterials;

    @Column(name = "alumetal_jumpo_labor")
    @JsonProperty("alumetalJumpoLabor")
    private Long alumetalJumpoLabor;

    @Column(name = "upvc_turkey_materials")
    @JsonProperty("upvcTurkeyMaterials")
    private Long upvcTurkeyMaterials;

    @Column(name = "upvc_turkey_labor")
    @JsonProperty("upvcTurkeyLabor")
    private Long upvcTurkeyLabor;

    @Column(name = "upvc_belgium_materials")
    @JsonProperty("upvcBelgiumMaterials")
    private Long upvcBelgiumMaterials;

    @Column(name = "upvc_belgium_labor")
    @JsonProperty("upvcBelgiumLabor")
    private Long upvcBelgiumLabor;

    @Column(name = "window_shutter_general_materials")
    @JsonProperty("windowShutterGeneralMaterials")
    private Long windowShutterGeneralMaterials;

    @Column(name = "window_shutter_general_labor")
    @JsonProperty("windowShutterGeneralLabor")
    private Long windowShutterGeneralLabor;

    @Column(name = "window_shutter_normal_materials")
    @JsonProperty("windowShutterNormalMaterials")
    private Long windowShutterNormalMaterials;

    @Column(name = "window_shutter_normal_labor")
    @JsonProperty("windowShutterNormalLabor")
    private Long windowShutterNormalLabor;

    @Column(name = "window_shutter_armored_materials")
    @JsonProperty("windowShutterArmoredMaterials")
    private Long windowShutterArmoredMaterials;

    @Column(name = "window_shutter_armored_labor")
    @JsonProperty("windowShutterArmoredLabor")
    private Long windowShutterArmoredLabor;

    @Column(name = "upvc_turkey_single_materials")
    @JsonProperty("upvcTurkeySingleMaterials")
    private Long upvcTurkeySingleMaterials;

    @Column(name = "upvc_turkey_single_labor")
    @JsonProperty("upvcTurkeySingleLabor")
    private Long upvcTurkeySingleLabor;

    @Column(name = "upvc_turkey_double_materials")
    @JsonProperty("upvcTurkeyDoubleMaterials")
    private Long upvcTurkeyDoubleMaterials;

    @Column(name = "upvc_turkey_double_labor")
    @JsonProperty("upvcTurkeyDoubleLabor")
    private Long upvcTurkeyDoubleLabor;

    @Column(name = "upvc_belgium_single_materials")
    @JsonProperty("upvcBelgiumSingleMaterials")
    private Long upvcBelgiumSingleMaterials;

    @Column(name = "upvc_belgium_single_labor")
    @JsonProperty("upvcBelgiumSingleLabor")
    private Long upvcBelgiumSingleLabor;

    @Column(name = "upvc_belgium_double_materials")
    @JsonProperty("upvcBelgiumDoubleMaterials")
    private Long upvcBelgiumDoubleMaterials;

    @Column(name = "upvc_belgium_double_labor")
    @JsonProperty("upvcBelgiumDoubleLabor")
    private Long upvcBelgiumDoubleLabor;

    @Column(name = "alumetal_ps_small_single_materials")
    @JsonProperty("alumetalPsSmallSingleMaterials")
    private Long alumetalPsSmallSingleMaterials;

    @Column(name = "alumetal_ps_small_single_labor")
    @JsonProperty("alumetalPsSmallSingleLabor")
    private Long alumetalPsSmallSingleLabor;

    @Column(name = "alumetal_ps_small_double_materials")
    @JsonProperty("alumetalPsSmallDoubleMaterials")
    private Long alumetalPsSmallDoubleMaterials;

    @Column(name = "alumetal_ps_small_double_labor")
    @JsonProperty("alumetalPsSmallDoubleLabor")
    private Long alumetalPsSmallDoubleLabor;

    @Column(name = "alumetal_ps_large_single_materials")
    @JsonProperty("alumetalPsLargeSingleMaterials")
    private Long alumetalPsLargeSingleMaterials;

    @Column(name = "alumetal_ps_large_single_labor")
    @JsonProperty("alumetalPsLargeSingleLabor")
    private Long alumetalPsLargeSingleLabor;

    @Column(name = "alumetal_ps_large_double_materials")
    @JsonProperty("alumetalPsLargeDoubleMaterials")
    private Long alumetalPsLargeDoubleMaterials;

    @Column(name = "alumetal_ps_large_double_labor")
    @JsonProperty("alumetalPsLargeDoubleLabor")
    private Long alumetalPsLargeDoubleLabor;

    @Column(name = "alumetal_jumbo_single_materials")
    @JsonProperty("alumetalJumboSingleMaterials")
    private Long alumetalJumboSingleMaterials;

    @Column(name = "alumetal_jumbo_single_labor")
    @JsonProperty("alumetalJumboSingleLabor")
    private Long alumetalJumboSingleLabor;

    @Column(name = "alumetal_jumbo_double_materials")
    @JsonProperty("alumetalJumboDoubleMaterials")
    private Long alumetalJumboDoubleMaterials;

    @Column(name = "alumetal_jumbo_double_labor")
    @JsonProperty("alumetalJumboDoubleLabor")
    private Long alumetalJumboDoubleLabor;

    @Column(name = "alumetal_tango_single_materials")
    @JsonProperty("alumetalTangoSingleMaterials")
    private Long alumetalTangoSingleMaterials;

    @Column(name = "alumetal_tango_single_labor")
    @JsonProperty("alumetalTangoSingleLabor")
    private Long alumetalTangoSingleLabor;

    @Column(name = "alumetal_tango_double_materials")
    @JsonProperty("alumetalTangoDoubleMaterials")
    private Long alumetalTangoDoubleMaterials;

    @Column(name = "alumetal_tango_double_labor")
    @JsonProperty("alumetalTangoDoubleLabor")
    private Long alumetalTangoDoubleLabor;
}