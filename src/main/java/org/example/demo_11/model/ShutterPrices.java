package org.example.demo_11.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShutterPrices {

    /**
     * سعر مواد ستائر الحماية العادية (بالريال)
     */
    @Column(name = "shutter_protection_materials")
    @JsonProperty("shutterProtectionMaterials")
    private Long shutterProtectionMaterials;

    /**
     * سعر عمالة تركيب ستائر الحماية العادية (بالريال)
     */
    @Column(name = "shutter_protection_labor")
    @JsonProperty("shutterProtectionLabor")
    private Long shutterProtectionLabor;

    /**
     * سعر مواد الستائر المقاومة للعوامل الجوية (بالريال)
     */
    @Column(name = "shutter_weather_resistant_materials")
    @JsonProperty("shutterWeatherResistantMaterials")
    private Long shutterWeatherResistantMaterials;

    /**
     * سعر عمالة تركيب الستائر المقاومة للعوامل الجوية (بالريال)
     */
    @Column(name = "shutter_weather_resistant_labor")
    @JsonProperty("shutterWeatherResistantLabor")
    private Long shutterWeatherResistantLabor;

    /**
     * سعر مواد الستائر المضادة للسرقة (بالريال)
     */
    @Column(name = "shutter_anti_theft_materials")
    @JsonProperty("shutterAntiTheftMaterials")
    private Long shutterAntiTheftMaterials;

    /**
     * سعر عمالة تركيب الستائر المضادة للسرقة (بالريال)
     */
    @Column(name = "shutter_anti_theft_labor")
    @JsonProperty("shutterAntiTheftLabor")
    private Long shutterAntiTheftLabor;
}