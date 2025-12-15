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
public class BathroomPrices {

    @Column(name = "basin_surface_materials")
    @JsonProperty("basinSurfaceMaterials")
    private Long basinSurfaceMaterials;

    @Column(name = "basin_surface_labor")
    @JsonProperty("basinSurfaceLabor")
    private Long basinSurfaceLabor;

    @Column(name = "basin_concealed_materials")
    @JsonProperty("basinConcealedMaterials")
    private Long basinConcealedMaterials;

    @Column(name = "basin_concealed_labor")
    @JsonProperty("basinConcealedLabor")
    private Long basinConcealedLabor;

    @Column(name = "buried_sink_mixer_materials")
    @JsonProperty("buriedSinkMixerMaterials")
    private Long buriedSinkMixerMaterials;

    @Column(name = "buried_sink_mixer_labor")
    @JsonProperty("buriedSinkMixerLabor")
    private Long buriedSinkMixerLabor;

    @Column(name = "shower_surface_materials")
    @JsonProperty("showerSurfaceMaterials")
    private Long showerSurfaceMaterials;

    @Column(name = "shower_surface_labor")
    @JsonProperty("showerSurfaceLabor")
    private Long showerSurfaceLabor;

    @Column(name = "shower_concealed_materials")
    @JsonProperty("showerConcealedMaterials")
    private Long showerConcealedMaterials;

    @Column(name = "shower_concealed_labor")
    @JsonProperty("showerConcealedLabor")
    private Long showerConcealedLabor;

    // تصحيح: إضافة underscores وتوضيح المعنى
    @Column(name = "shower_concealed_two_outlet_materials")
    @JsonProperty("showerConcealedTwoOutletMaterials")
    private Long showerConcealedTwoOutletMaterials;

    @Column(name = "shower_concealed_two_outlet_labor")
    @JsonProperty("showerConcealedTwoOutletLabor")
    private Long showerConcealedTwoOutletLabor;

    @Column(name = "buried_shower_mixer_two_outlet_materials")
    @JsonProperty("buriedShowerMixerTwoOutletMaterials")
    private Long buriedShowerMixerTwoOutletMaterials;

    @Column(name = "buried_shower_mixer_two_outlet_labor")
    @JsonProperty("buriedShowerMixerTwoOutletLabor")
    private Long buriedShowerMixerTwoOutletLabor;

    @Column(name = "shower_concealed_three_outlet_materials")
    @JsonProperty("showerConcealedThreeOutletMaterials")
    private Long showerConcealedThreeOutletMaterials;

    @Column(name = "shower_concealed_three_outlet_labor")
    @JsonProperty("showerConcealedThreeOutletLabor")
    private Long showerConcealedThreeOutletLabor;

    @Column(name = "buried_shower_mixer_three_outlet_materials")
    @JsonProperty("buriedShowerMixerThreeOutletMaterials")
    private Long buriedShowerMixerThreeOutletMaterials;

    @Column(name = "buried_shower_mixer_three_outlet_labor")
    @JsonProperty("buriedShowerMixerThreeOutletLabor")
    private Long buriedShowerMixerThreeOutletLabor;

    @Column(name = "shower_smart_materials")
    @JsonProperty("showerSmartMaterials")
    private Long showerSmartMaterials;

    @Column(name = "shower_smart_labor")
    @JsonProperty("showerSmartLabor")
    private Long showerSmartLabor;

    @Column(name = "shattaf_surface_materials")
    @JsonProperty("shattafSurfaceMaterials")
    private Long shattafSurfaceMaterials;

    @Column(name = "shattaf_surface_labor")
    @JsonProperty("shattafSurfaceLabor")
    private Long shattafSurfaceLabor;

    @Column(name = "shattaf_concealed_materials")
    @JsonProperty("shattafConcealedMaterials")
    private Long shattafConcealedMaterials;

    @Column(name = "shattaf_concealed_labor")
    @JsonProperty("shattafConcealedLabor")
    private Long shattafConcealedLabor;

    @Column(name = "buried_shattaf_mixer_materials")
    @JsonProperty("buriedShattafMixerMaterials")
    private Long buriedShattafMixerMaterials;

    @Column(name = "buried_shattaf_mixer_labor")
    @JsonProperty("buriedShattafMixerLabor")
    private Long buriedShattafMixerLabor;

    @Column(name = "shattaf_hanging_materials")
    @JsonProperty("shattafHangingMaterials")
    private Long shattafHangingMaterials;

    @Column(name = "shattaf_hanging_labor")
    @JsonProperty("shattafHangingLabor")
    private Long shattafHangingLabor;

    @Column(name = "wall_hung_concealed_materials")
    @JsonProperty("wallHungConcealedMaterials")
    private Long wallHungConcealedMaterials;

    @Column(name = "wall_hung_concealed_labor")
    @JsonProperty("wallHungConcealedLabor")
    private Long wallHungConcealedLabor;

    @Column(name = "base_wall_hung_concealed_materials")
    @JsonProperty("baseWallHungConcealedMaterials")
    private Long baseWallHungConcealedMaterials;

    @Column(name = "base_wall_hung_concealed_labor")
    @JsonProperty("baseWallHungConcealedLabor")
    private Long baseWallHungConcealedLabor;

    @Column(name = "base_wall_hung_concealed_box_materials")
    @JsonProperty("baseWallHungConcealedBoxMaterials")
    private Long baseWallHungConcealedBoxMaterials;

    @Column(name = "base_wall_hung_concealed_box_labor")
    @JsonProperty("baseWallHungConcealedBoxLabor")
    private Long baseWallHungConcealedBoxLabor;

    // تصحيح: إضافة underscore
    @Column(name = "base_floor_standing_materials")
    @JsonProperty("baseFloorStandingMaterials")
    private Long baseFloorStandingMaterials;

    @Column(name = "base_floor_standing_labor")
    @JsonProperty("baseFloorStandingLabor")
    private Long baseFloorStandingLabor;

    @Column(name = "bathtub_materials")
    @JsonProperty("bathtubMaterials")
    private Long bathtubMaterials;

    @Column(name = "bathtub_labor")
    @JsonProperty("bathtubLabor")
    private Long bathtubLabor;

    @Column(name = "jacuzzi_materials")
    @JsonProperty("jacuzziMaterials")
    private Long jacuzziMaterials;

    @Column(name = "jacuzzi_labor")
    @JsonProperty("jacuzziLabor")
    private Long jacuzziLabor;

    // تصحيح: إضافة underscores
    @Column(name = "shower_base_glass_80_210_materials")
    @JsonProperty("showerBaseGlass80_210Materials")
    private Long showerBaseGlass80_210Materials;

    @Column(name = "shower_base_glass_80_210_labor")
    @JsonProperty("showerBaseGlass80_210Labor")
    private Long showerBaseGlass80_210Labor;

    @Column(name = "shower_none_materials")
    @JsonProperty("showerNoneMaterials")
    private Long showerNoneMaterials;

    @Column(name = "shower_none_labor")
    @JsonProperty("showerNoneLabor")
    private Long showerNoneLabor;

    // تصحيح: توحيد التسمية
    @Column(name = "shower_base_materials")
    @JsonProperty("showerBaseMaterials")
    private Long showerBaseMaterials;

    @Column(name = "shower_base_labor")
    @JsonProperty("showerBaseLabor")
    private Long showerBaseLabor;

    @Column(name = "sink_above_unit_materials")
    @JsonProperty("sinkAboveUnitMaterials")
    private Long sinkAboveUnitMaterials;

    @Column(name = "sink_above_unit_labor")
    @JsonProperty("sinkAboveUnitLabor")
    private Long sinkAboveUnitLabor;

    @Column(name = "sink_half_pedestal_materials")
    @JsonProperty("sinkHalfPedestalMaterials")
    private Long sinkHalfPedestalMaterials;

    @Column(name = "sink_half_pedestal_labor")
    @JsonProperty("sinkHalfPedestalLabor")
    private Long sinkHalfPedestalLabor;

    @Column(name = "sink_marble_materials")
    @JsonProperty("sinkMarbleMaterials")
    private Long sinkMarbleMaterials;

    @Column(name = "sink_marble_labor")
    @JsonProperty("sinkMarbleLabor")
    private Long sinkMarbleLabor;

    @Column(name = "sink_porcelain_materials")
    @JsonProperty("sinkPorcelainMaterials")
    private Long sinkPorcelainMaterials;

    @Column(name = "sink_porcelain_labor")
    @JsonProperty("sinkPorcelainLabor")
    private Long sinkPorcelainLabor;
}