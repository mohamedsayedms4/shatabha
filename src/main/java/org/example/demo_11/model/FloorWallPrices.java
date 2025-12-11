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
public class FloorWallPrices {

    @Column(name = "marble_floor_breccia_materials")
    @JsonProperty("marbleFloorBrecciaMaterials")
    private Long marbleFloorBrecciaMaterials;

    @Column(name = "marble_floor_breccia_labor")
    @JsonProperty("marbleFloorBrecciaLabor")
    private Long marbleFloorBrecciaLabor;

    @Column(name = "marble_floor_pietra_gray_materials")
    @JsonProperty("marbleFloorPietraGrayMaterials")
    private Long marbleFloorPietraGrayMaterials;

    @Column(name = "marble_floor_pietra_gray_labor")
    @JsonProperty("marbleFloorPietraGrayLabor")
    private Long marbleFloorPietraGrayLabor;

    @Column(name = "marble_floor_karrara_materials")
    @JsonProperty("marbleFloorKarraraMaterials")
    private Long marbleFloorKarraraMaterials;

    @Column(name = "marble_floor_karrara_labor")
    @JsonProperty("marbleFloorKarraraLabor")
    private Long marbleFloorKarraraLabor;

    @Column(name = "marble_floor_other_materials")
    @JsonProperty("marbleFloorOtherMaterials")
    private Long marbleFloorOtherMaterials;

    @Column(name = "marble_floor_other_labor")
    @JsonProperty("marbleFloorOtherLabor")
    private Long marbleFloorOtherLabor;

    @Column(name = "hdfgermanparquet_materials")
    @JsonProperty("hdfgermanparquetMaterials")
    private Long HDFGERMANParquetMaterials;

    @Column(name = "hdfgermanparquet_labor")
    @JsonProperty("hdfgermanparquetLabor")
    private Long HDFGERMANParquetLabor;

    @Column(name = "hdfwaterproofparquet_materials")
    @JsonProperty("hdfwaterproofparquetMaterials")
    private Long HDFWATERPROOFParquetMaterials;

    @Column(name = "hdfwaterproofparquet_labor")
    @JsonProperty("hdfwaterproofparquetLabor")
    private Long HDFWATERPROOFParquetLabor;

    @Column(name = "pcdparquet_materials")
    @JsonProperty("pcdparquetMaterials")
    private Long PCDParquetMaterials;

    @Column(name = "pcdparquet_labor")
    @JsonProperty("pcdparquetLabor")
    private Long PCDParquetLabor;

    @Column(name = "porcelain60x80parquet_materials")
    @JsonProperty("porcelain60x80ParquetMaterials")
    private Long PORCELAIN60x80ParquetMaterials;

    @Column(name = "porcelain60x80parquet_labor")
    @JsonProperty("porcelain60x80ParquetLabor")
    private Long PORCELAIN60x80ParquetLabor;

    @Column(name = "porcelain85x125parquet_materials")
    @JsonProperty("porcelain85x125ParquetMaterials")
    private Long PORCELAIN85x125ParquetMaterials;

    @Column(name = "porcelain85x125parquet_labor")
    @JsonProperty("porcelain85x125ParquetLabor")
    private Long PORCELAIN85x125ParquetLabor;

    @Column(name = "spcimportedparquet_materials")
    @JsonProperty("spcimportedparquetMaterials")
    private Long SPCIMPORTEDParquetMaterials;

    @Column(name = "spcimportedparquet_labor")
    @JsonProperty("spcimportedparquetLabor")
    private Long SPCIMPORTEDParquetLabor;

    @Column(name = "spclocalparquet_materials")
    @JsonProperty("spclocalparquetMaterials")
    private Long SPCLOCALParquetMaterials;

    @Column(name = "spclocalparquet_labor")
    @JsonProperty("spclocalparquetLabor")
    private Long SPCLOCALParquetLabor;

    @Column(name = "ceramic_floor60x60materials")
    @JsonProperty("ceramicFloor60x60Materials")
    private Long ceramicFloor60x60Materials;

    @Column(name = "ceramic_floor60x60labor")
    @JsonProperty("ceramicFloor60x60Labor")
    private Long ceramicFloor60x60Labor;

    @Column(name = "ceramic_floor120x60materials")
    @JsonProperty("ceramicFloor120x60Materials")
    private Long ceramicFloor120x60Materials;

    @Column(name = "ceramic_floor120x60labor")
    @JsonProperty("ceramicFloor120x60Labor")
    private Long ceramicFloor120x60Labor;

    @Column(name = "local_porcelain_floor60x120materials")
    @JsonProperty("localPorcelainFloor60x120Materials")
    private Long localPorcelainFloor60x120Materials;

    @Column(name = "local_porcelain_floor60x120labor")
    @JsonProperty("localPorcelainFloor60x120Labor")
    private Long localPorcelainFloor60x120Labor;

    @Column(name = "hindi_porcelain_floor60x120materials")
    @JsonProperty("hindiPorcelainFloor60x120Materials")
    private Long hindiPorcelainFloor60x120Materials;

    @Column(name = "hindi_porcelain_floor60x120labor")
    @JsonProperty("hindiPorcelainFloor60x120Labor")
    private Long hindiPorcelainFloor60x120Labor;

    @Column(name = "hindi_porcelain_floor120x180materials")
    @JsonProperty("hindiPorcelainFloor120x180Materials")
    private Long hindiPorcelainFloor120x180Materials;

    @Column(name = "hindi_porcelain_floor120x180labor")
    @JsonProperty("hindiPorcelainFloor120x180Labor")
    private Long hindiPorcelainFloor120x180Labor;

    @Column(name = "hindi_porcelain_floor120x240materials")
    @JsonProperty("hindiPorcelainFloor120x240Materials")
    private Long hindiPorcelainFloor120x240Materials;

    @Column(name = "hindi_porcelain_floor120x240labor")
    @JsonProperty("hindiPorcelainFloor120x240Labor")
    private Long hindiPorcelainFloor120x240Labor;

    @Column(name = "spanish_porcelain_floor60x120materials")
    @JsonProperty("spanishPorcelainFloor60x120Materials")
    private Long spanishPorcelainFloor60x120Materials;

    @Column(name = "spanish_porcelain_floor60x120labor")
    @JsonProperty("spanishPorcelainFloor60x120Labor")
    private Long spanishPorcelainFloor60x120Labor;

    @Column(name = "spanish_porcelain_floor120x180materials")
    @JsonProperty("spanishPorcelainFloor120x180Materials")
    private Long spanishPorcelainFloor120x180Materials;

    @Column(name = "spanish_porcelain_floor120x180labor")
    @JsonProperty("spanishPorcelainFloor120x180Labor")
    private Long spanishPorcelainFloor120x180Labor;

    @Column(name = "spanish_porcelain_floor120x240materials")
    @JsonProperty("spanishPorcelainFloor120x240Materials")
    private Long spanishPorcelainFloor120x240Materials;

    @Column(name = "spanish_porcelain_floor120x240labor")
    @JsonProperty("spanishPorcelainFloor120x240Labor")
    private Long spanishPorcelainFloor120x240Labor;

    @Column(name = "paint_normalmaterials")
    @JsonProperty("paint_NORMALMaterials")
    private Long PAINT_NORMALMaterials;

    @Column(name = "paint_normallabor")
    @JsonProperty("paint_NORMALLabor")
    private Long PAINT_NORMALLabor;

    @Column(name = "paint_dicoarmaterials")
    @JsonProperty("paint_DICOARMaterials")
    private Long PAINT_DICOARMaterials;

    @Column(name = "paint_dicoarlabor")
    @JsonProperty("paint_DICOARLabor")
    private Long PAINT_DICOARLabor;

    @Column(name = "tagliad_madematerials")
    @JsonProperty("tagliad_MADEMaterials")
    private Long TAGLIAD_MADEMaterials;

    @Column(name = "tagliad_madelabor")
    @JsonProperty("tagliad_MADELabor")
        private Long TAGLIAD_MADELabor;

    @Column(name = "tagliad_normalmaterials")
    @JsonProperty("tagliad_NORMALMaterials")
    private Long TAGLIAD_NORMALMaterials;

    @Column(name = "tagliad_normallabor")
    @JsonProperty("tagliad_NORMALLabor")
    private Long TAGLIAD_NORMALLabor;

    @Column(name = "banohatmaterials")
    @JsonProperty("banohatmaterials")
    private Long BANOHATMaterials;

    @Column(name = "banohatlabor")
    @JsonProperty("banohatlabor")
    private Long BANOHATLabor;

    @Column(name = "ceramic_wall60x30materials")
    @JsonProperty("ceramicWall60x30Materials")
    private Long ceramicWall60x30Materials;

    @Column(name = "ceramic_wall60x30labor")
    @JsonProperty("ceramicWall60x30Labor")
    private Long ceramicWall60x30Labor;

    @Column(name = "ceramic_wall75x25materials")
    @JsonProperty("ceramicWall75x25Materials")
    private Long ceramicWall75x25Materials;

    @Column(name = "ceramic_wall75x25labor")
    @JsonProperty("ceramicWall75x25Labor")
    private Long ceramicWall75x25Labor;

    @Column(name = "ceramic_wall120x60materials")
    @JsonProperty("ceramicWall120x60Materials")
    private Long ceramicWall120x60Materials;

    @Column(name = "ceramic_wall120x60labor")
    @JsonProperty("ceramicWall120x60Labor")
    private Long ceramicWall120x60Labor;

    @Column(name = "local_porcelain_wall60x120materials")
    @JsonProperty("localPorcelainWall60x120Materials")
    private Long localPorcelainWall60x120Materials;

    @Column(name = "local_porcelain_wall60x120labor")
    @JsonProperty("localPorcelainWall60x120Labor")
    private Long localPorcelainWall60x120Labor;

    @Column(name = "hindi_porcelain_wall60x120materials")
    @JsonProperty("hindiPorcelainWall60x120Materials")
    private Long hindiPorcelainWall60x120Materials;

    @Column(name = "hindi_porcelain_wall60x120labor")
    @JsonProperty("hindiPorcelainWall60x120Labor")
    private Long hindiPorcelainWall60x120Labor;

    @Column(name = "hindi_porcelain_wall120x180materials")
    @JsonProperty("hindiPorcelainWall120x180Materials")
    private Long hindiPorcelainWall120x180Materials;

    @Column(name = "hindi_porcelain_wall120x180labor")
    @JsonProperty("hindiPorcelainWall120x180Labor")
    private Long hindiPorcelainWall120x180Labor;

    @Column(name = "hindi_porcelain_wall120x240materials")
    @JsonProperty("hindiPorcelainWall120x240Materials")
    private Long hindiPorcelainWall120x240Materials;

    @Column(name = "hindi_porcelain_wall120x240labor")
    @JsonProperty("hindiPorcelainWall120x240Labor")
    private Long hindiPorcelainWall120x240Labor;

    @Column(name = "spanish_porcelain_wall60x120materials")
    @JsonProperty("spanishPorcelainWall60x120Materials")
    private Long spanishPorcelainWall60x120Materials;

    @Column(name = "spanish_porcelain_wall60x120labor")
    @JsonProperty("spanishPorcelainWall60x120Labor")
    private Long spanishPorcelainWall60x120Labor;

    @Column(name = "spanish_porcelain_wall120x180materials")
    @JsonProperty("spanishPorcelainWall120x180Materials")
    private Long spanishPorcelainWall120x180Materials;

    @Column(name = "spanish_porcelain_wall120x180labor")
    @JsonProperty("spanishPorcelainWall120x180Labor")
    private Long spanishPorcelainWall120x180Labor;

    @Column(name = "spanish_porcelain_wall120x240materials")
    @JsonProperty("spanishPorcelainWall120x240Materials")
    private Long spanishPorcelainWall120x240Materials;

    @Column(name = "spanish_porcelain_wall120x240labor")
    @JsonProperty("spanishPorcelainWall120x240Labor")
    private Long spanishPorcelainWall120x240Labor;
}