package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorWallPrices {
    // ============ الرخام ============
    private Long marbleFloorBrecciaMaterials;
    private Long marbleFloorBrecciaLabor;
    private Long marbleFloorPietraGrayMaterials;
    private Long marbleFloorPietraGrayLabor;
    private Long marbleFloorKarraraMaterials;
    private Long marbleFloorKarraraLabor;
    private Long marbleFloorOtherMaterials;
    private Long marbleFloorOtherLabor;

    // ============ الباركيه الجديدة ============
    private Long HDFGERMANParquetMaterials;
    private Long HDFGERMANParquetLabor;
    private Long HDFWATERPROOFParquetMaterials;
    private Long HDFWATERPROOFParquetLabor;
    private Long PCDParquetMaterials;
    private Long PCDParquetLabor;
    private Long PORCELAIN60x80ParquetMaterials;
    private Long PORCELAIN60x80ParquetLabor ;
    private Long PORCELAIN85x125ParquetMaterials;
    private Long PORCELAIN85x125ParquetLabor;
    private Long SPCIMPORTEDParquetMaterials;
    private Long SPCIMPORTEDParquetLabor;
    private Long SPCLOCALParquetMaterials;
    private Long SPCLOCALParquetLabor;

    // ============ سيراميك أرضيات ============
    private Long ceramicFloor60x60Materials;
    private Long ceramicFloor60x60Labor;
    private Long ceramicFloor120x60Materials;
    private Long ceramicFloor120x60Labor;

    // ============ بورسلين محلي ============
    private Long localPorcelainFloor60x120Materials;
    private Long localPorcelainFloor60x120Labor;

    // ============ بورسلين هندي أرضيات ============
    private Long hindiPorcelainFloor60x120Materials;
    private Long hindiPorcelainFloor60x120Labor;
    private Long hindiPorcelainFloor120x180Materials;
    private Long hindiPorcelainFloor120x180Labor;
    private Long hindiPorcelainFloor120x240Materials;
    private Long hindiPorcelainFloor120x240Labor;

    // ============ بورسلين اسباني أرضيات ============
    private Long spanishPorcelainFloor60x120Materials;
    private Long spanishPorcelainFloor60x120Labor;
    private Long spanishPorcelainFloor120x180Materials;
    private Long spanishPorcelainFloor120x180Labor;
    private Long spanishPorcelainFloor120x240Materials;
    private Long spanishPorcelainFloor120x240Labor;


    // ============ الدهان ============
    private Long PAINT_NORMALMaterials;
    private Long PAINT_NORMALLabor;
    private Long PAINT_DICOARMaterials;
    private Long PAINT_DICOARLabor;
    private Long TAGLIAD_MADEMaterials;
    private Long TAGLIAD_MADELabor;
    private Long TAGLIAD_NORMALMaterials;
    private Long TAGLIAD_NORMALLabor;
    private Long BANOHATMaterials;
    private Long BANOHATLabor;


    // ============ سيراميك حوائط ============
    private Long ceramicWall60x30Materials;
    private Long ceramicWall60x30Labor;
    private Long ceramicWall75x25Materials;
    private Long ceramicWall75x25Labor;
    private Long ceramicWall120x60Materials;
    private Long ceramicWall120x60Labor;

    // ============ بورسلين حوائط محلي ============
    private Long localPorcelainWall60x120Materials;
    private Long localPorcelainWall60x120Labor;

    // ============ بورسلين حوائط هندي ============
    private Long hindiPorcelainWall60x120Materials;
    private Long hindiPorcelainWall60x120Labor;
    private Long hindiPorcelainWall120x180Materials;
    private Long hindiPorcelainWall120x180Labor;
    private Long hindiPorcelainWall120x240Materials;
    private Long hindiPorcelainWall120x240Labor;

    // ============ بورسلين حوائط اسباني ============
    private Long spanishPorcelainWall60x120Materials;
    private Long spanishPorcelainWall60x120Labor;
    private Long spanishPorcelainWall120x180Materials;
    private Long spanishPorcelainWall120x180Labor;
    private Long spanishPorcelainWall120x240Materials;
    private Long spanishPorcelainWall120x240Labor;
}