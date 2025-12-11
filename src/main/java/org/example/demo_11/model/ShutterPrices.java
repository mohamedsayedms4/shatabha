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
public class ShutterPrices {

    @Column(name = "shutter_protection_materials")
    @JsonProperty("shutterProtectionMaterials")
    private Long shutterProtectionMaterials;

    @Column(name = "shutter_protection_labor")
    @JsonProperty("shutterProtectionLabor")
    private Long shutterProtectionLabor;

    @Column(name = "shutter_weather_resistant_materials")
    @JsonProperty("shutterWeatherResistantMaterials")
    private Long shutterWeatherResistantMaterials;

    @Column(name = "shutter_weather_resistant_labor")
    @JsonProperty("shutterWeatherResistantLabor")
    private Long shutterWeatherResistantLabor;

    @Column(name = "shutter_anti_theft_materials")
    @JsonProperty("shutterAntiTheftMaterials")
    private Long shutterAntiTheftMaterials;

    @Column(name = "shutter_anti_theft_labor")
    @JsonProperty("shutterAntiTheftLabor")
    private Long shutterAntiTheftLabor;
}