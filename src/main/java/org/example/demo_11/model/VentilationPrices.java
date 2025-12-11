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
public class VentilationPrices {

    @Column(name = "window_exhaust_materials")
    @JsonProperty("windowExhaustMaterials")
    private Long windowExhaustMaterials;

    @Column(name = "window_exhaust_labor")
    @JsonProperty("windowExhaustLabor")
    private Long windowExhaustLabor;

    @Column(name = "ceiling_exhaust_materials")
    @JsonProperty("ceilingExhaustMaterials")
    private Long ceilingExhaustMaterials;

    @Column(name = "ceiling_exhaust_labor")
    @JsonProperty("ceilingExhaustLabor")
    private Long ceilingExhaustLabor;
}