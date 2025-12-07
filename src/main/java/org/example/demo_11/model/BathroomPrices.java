

// ============================================
// 6. BathroomPrices
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
public class BathroomPrices {
    private Long basinSurfaceMaterials;
    private Long basinSurfaceLabor;
    private Long basinConcealedMaterials;
    private Long basinConcealedLabor;
    private Long buriedSinkMixerMaterials;
    private Long buriedSinkMixerLabor;
    private Long showerSurfaceMaterials;
    private Long showerSurfaceLabor;
    private Long showerConcealedMaterials;
    private Long showerConcealedLabor;
    private Long showerConcealed2Materials;
    private Long showerConcealed2Labor;
    private Long buriedShowerMixer2OutletMaterials;
    private Long buriedShowerMixer2OutletLabor;
    private Long showerConcealed3Materials;
    private Long showerConcealed3Labor;
    private Long buriedShowerMixer3OutletMaterials;
    private Long buriedShowerMixer3OutletLabor;
    private Long showerSmartMaterials;
    private Long showerSmartLabor;
    private Long shattafSurfaceMaterials;
    private Long shattafSurfaceLabor;
    private Long shattafConcealedMaterials;
    private Long shattafConcealedLabor;
    private Long buriedShattafMixerMaterials;
    private Long buriedShattafMixerLabor;
    private Long shattafHangingMaterials;
    private Long shattafHangingLabor;
    private Long wallHungConcealedMaterials;
    private Long wallHungConcealedLabor;
    private Long baseWallHungConcealedMaterials;
    private Long baseWallHungConcealedLabor;
    private Long baseWallHungConcealedBoxMaterials;
    private Long baseWallHungConcealedBoxLabor;
    private Long basefloorStandingMaterials;
    private Long basefloorStandingLabor;
    private Long bathtubMaterials;
    private Long bathtubLabor;
    private Long jacuzziMaterials;
    private Long jacuzziLabor;
    private Long showerBaseGlass80_210Materials;
    private Long showerBaseGlass80_210Labor;
    private Long showerNoneMaterials;
    private Long showerNoneLabor;
    private Long shower_baseLabor;
    private Long shower_baseMaterials;
    private Long sinkAboveUnitMaterials;
    private Long sinkAboveUnitLabor;
    private Long sinkHalfPedestalMaterials;
    private Long sinkHalfPedestalLabor;
    private Long sinkMarbleMaterials;
    private Long sinkMarbleLabor;
    private Long sinkPorcelainMaterials;
    private Long sinkPorcelainLabor;
}
