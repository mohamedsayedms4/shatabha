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

    // تصحيح: توحيد التسمية
    @Column(name = "hdf_german_parquet_materials")
    @JsonProperty("hdfGermanParquetMaterials")
    private Long hdfGermanParquetMaterials;

    @Column(name = "hdf_german_parquet_labor")
    @JsonProperty("hdfGermanParquetLabor")
    private Long hdfGermanParquetLabor;

    @Column(name = "hdf_waterproof_parquet_materials")
    @JsonProperty("hdfWaterproofParquetMaterials")
    private Long hdfWaterproofParquetMaterials;

    @Column(name = "hdf_waterproof_parquet_labor")
    @JsonProperty("hdfWaterproofParquetLabor")
    private Long hdfWaterproofParquetLabor;

    @Column(name = "pcd_parquet_materials")
    @JsonProperty("pcdParquetMaterials")
    private Long pcdParquetMaterials;

    @Column(name = "pcd_parquet_labor")
    @JsonProperty("pcdParquetLabor")
    private Long pcdParquetLabor;

    @Column(name = "porcelain_60x80_parquet_materials")
    @JsonProperty("porcelain60x80ParquetMaterials")
    private Long porcelain60x80ParquetMaterials;

    @Column(name = "porcelain_60x80_parquet_labor")
    @JsonProperty("porcelain60x80ParquetLabor")
    private Long porcelain60x80ParquetLabor;

    @Column(name = "porcelain_85x125_parquet_materials")
    @JsonProperty("porcelain85x125ParquetMaterials")
    private Long porcelain85x125ParquetMaterials;

    @Column(name = "porcelain_85x125_parquet_labor")
    @JsonProperty("porcelain85x125ParquetLabor")
    private Long porcelain85x125ParquetLabor;

    @Column(name = "spc_imported_parquet_materials")
    @JsonProperty("spcImportedParquetMaterials")
    private Long spcImportedParquetMaterials;

    @Column(name = "spc_imported_parquet_labor")
    @JsonProperty("spcImportedParquetLabor")
    private Long spcImportedParquetLabor;

    @Column(name = "spc_local_parquet_materials")
    @JsonProperty("spcLocalParquetMaterials")
    private Long spcLocalParquetMaterials;

    @Column(name = "spc_local_parquet_labor")
    @JsonProperty("spcLocalParquetLabor")
    private Long spcLocalParquetLabor;

    // تصحيح: إضافة underscores
    @Column(name = "ceramic_floor_60x60_materials")
    @JsonProperty("ceramicFloor60x60Materials")
    private Long ceramicFloor60x60Materials;

    @Column(name = "ceramic_floor_60x60_labor")
    @JsonProperty("ceramicFloor60x60Labor")
    private Long ceramicFloor60x60Labor;

    @Column(name = "ceramic_floor_120x60_materials")
    @JsonProperty("ceramicFloor120x60Materials")
    private Long ceramicFloor120x60Materials;

    @Column(name = "ceramic_floor_120x60_labor")
    @JsonProperty("ceramicFloor120x60Labor")
    private Long ceramicFloor120x60Labor;

    @Column(name = "local_porcelain_floor_60x120_materials")
    @JsonProperty("localPorcelainFloor60x120Materials")
    private Long localPorcelainFloor60x120Materials;

    @Column(name = "local_porcelain_floor_60x120_labor")
    @JsonProperty("localPorcelainFloor60x120Labor")
    private Long localPorcelainFloor60x120Labor;

    @Column(name = "hindi_porcelain_floor_60x120_materials")
    @JsonProperty("hindiPorcelainFloor60x120Materials")
    private Long hindiPorcelainFloor60x120Materials;

    @Column(name = "hindi_porcelain_floor_60x120_labor")
    @JsonProperty("hindiPorcelainFloor60x120Labor")
    private Long hindiPorcelainFloor60x120Labor;

    @Column(name = "hindi_porcelain_floor_120x180_materials")
    @JsonProperty("hindiPorcelainFloor120x180Materials")
    private Long hindiPorcelainFloor120x180Materials;

    @Column(name = "hindi_porcelain_floor_120x180_labor")
    @JsonProperty("hindiPorcelainFloor120x180Labor")
    private Long hindiPorcelainFloor120x180Labor;

    @Column(name = "hindi_porcelain_floor_120x240_materials")
    @JsonProperty("hindiPorcelainFloor120x240Materials")
    private Long hindiPorcelainFloor120x240Materials;

    @Column(name = "hindi_porcelain_floor_120x240_labor")
    @JsonProperty("hindiPorcelainFloor120x240Labor")
    private Long hindiPorcelainFloor120x240Labor;

    @Column(name = "spanish_porcelain_floor_60x120_materials")
    @JsonProperty("spanishPorcelainFloor60x120Materials")
    private Long spanishPorcelainFloor60x120Materials;

    @Column(name = "spanish_porcelain_floor_60x120_labor")
    @JsonProperty("spanishPorcelainFloor60x120Labor")
    private Long spanishPorcelainFloor60x120Labor;

    @Column(name = "spanish_porcelain_floor_120x180_materials")
    @JsonProperty("spanishPorcelainFloor120x180Materials")
    private Long spanishPorcelainFloor120x180Materials;

    @Column(name = "spanish_porcelain_floor_120x180_labor")
    @JsonProperty("spanishPorcelainFloor120x180Labor")
    private Long spanishPorcelainFloor120x180Labor;

    @Column(name = "spanish_porcelain_floor_120x240_materials")
    @JsonProperty("spanishPorcelainFloor120x240Materials")
    private Long spanishPorcelainFloor120x240Materials;

    @Column(name = "spanish_porcelain_floor_120x240_labor")
    @JsonProperty("spanishPorcelainFloor120x240Labor")
    private Long spanishPorcelainFloor120x240Labor;

    // تصحيح: إزالة underscore من JSON وتوحيد التسمية
    @Column(name = "paint_normal_materials")
    @JsonProperty("paintNormalMaterials")
    private Long paintNormalMaterials;

    @Column(name = "paint_normal_labor")
    @JsonProperty("paintNormalLabor")
    private Long paintNormalLabor;

    @Column(name = "paint_dicoar_materials")
    @JsonProperty("paintDicoarMaterials")
    private Long paintDicoarMaterials;

    @Column(name = "paint_dicoar_labor")
    @JsonProperty("paintDicoarLabor")
    private Long paintDicoarLabor;

    @Column(name = "tagliad_made_materials")
    @JsonProperty("tagliadMadeMaterials")
    private Long tagliadMadeMaterials;

    @Column(name = "tagliad_made_labor")
    @JsonProperty("tagliadMadeLabor")
    private Long tagliadMadeLabor;

    @Column(name = "tagliad_normal_materials")
    @JsonProperty("tagliadNormalMaterials")
    private Long tagliadNormalMaterials;

    @Column(name = "tagliad_normal_labor")
    @JsonProperty("tagliadNormalLabor")
    private Long tagliadNormalLabor;

    // تصحيح: توضيح المعنى (ربما "banoh at" أو شيء آخر)
    @Column(name = "banoh_at_materials")
    @JsonProperty("banohAtMaterials")
    private Long banohAtMaterials;

    @Column(name = "banoh_at_labor")
    @JsonProperty("banohAtLabor")
    private Long banohAtLabor;

    @Column(name = "ceramic_wall_60x30_materials")
    @JsonProperty("ceramicWall60x30Materials")
    private Long ceramicWall60x30Materials;

    @Column(name = "ceramic_wall_60x30_labor")
    @JsonProperty("ceramicWall60x30Labor")
    private Long ceramicWall60x30Labor;

    @Column(name = "ceramic_wall_75x25_materials")
    @JsonProperty("ceramicWall75x25Materials")
    private Long ceramicWall75x25Materials;

    @Column(name = "ceramic_wall_75x25_labor")
    @JsonProperty("ceramicWall75x25Labor")
    private Long ceramicWall75x25Labor;

    @Column(name = "ceramic_wall_120x60_materials")
    @JsonProperty("ceramicWall120x60Materials")
    private Long ceramicWall120x60Materials;

    @Column(name = "ceramic_wall_120x60_labor")
    @JsonProperty("ceramicWall120x60Labor")
    private Long ceramicWall120x60Labor;

    @Column(name = "local_porcelain_wall_60x120_materials")
    @JsonProperty("localPorcelainWall60x120Materials")
    private Long localPorcelainWall60x120Materials;

    @Column(name = "local_porcelain_wall_60x120_labor")
    @JsonProperty("localPorcelainWall60x120Labor")
    private Long localPorcelainWall60x120Labor;

    @Column(name = "hindi_porcelain_wall_60x120_materials")
    @JsonProperty("hindiPorcelainWall60x120Materials")
    private Long hindiPorcelainWall60x120Materials;

    @Column(name = "hindi_porcelain_wall_60x120_labor")
    @JsonProperty("hindiPorcelainWall60x120Labor")
    private Long hindiPorcelainWall60x120Labor;

    @Column(name = "hindi_porcelain_wall_120x180_materials")
    @JsonProperty("hindiPorcelainWall120x180Materials")
    private Long hindiPorcelainWall120x180Materials;

    @Column(name = "hindi_porcelain_wall_120x180_labor")
    @JsonProperty("hindiPorcelainWall120x180Labor")
    private Long hindiPorcelainWall120x180Labor;

    @Column(name = "hindi_porcelain_wall_120x240_materials")
    @JsonProperty("hindiPorcelainWall120x240Materials")
    private Long hindiPorcelainWall120x240Materials;

    @Column(name = "hindi_porcelain_wall_120x240_labor")
    @JsonProperty("hindiPorcelainWall120x240Labor")
    private Long hindiPorcelainWall120x240Labor;

    @Column(name = "spanish_porcelain_wall_60x120_materials")
    @JsonProperty("spanishPorcelainWall60x120Materials")
    private Long spanishPorcelainWall60x120Materials;

    @Column(name = "spanish_porcelain_wall_60x120_labor")
    @JsonProperty("spanishPorcelainWall60x120Labor")
    private Long spanishPorcelainWall60x120Labor;

    @Column(name = "spanish_porcelain_wall_120x180_materials")
    @JsonProperty("spanishPorcelainWall120x180Materials")
    private Long spanishPorcelainWall120x180Materials;

    @Column(name = "spanish_porcelain_wall_120x180_labor")
    @JsonProperty("spanishPorcelainWall120x180Labor")
    private Long spanishPorcelainWall120x180Labor;

    @Column(name = "spanish_porcelain_wall_120x240_materials")
    @JsonProperty("spanishPorcelainWall120x240Materials")
    private Long spanishPorcelainWall120x240Materials;

    @Column(name = "spanish_porcelain_wall_120x240_labor")
    @JsonProperty("spanishPorcelainWall120x240Labor")
    private Long spanishPorcelainWall120x240Labor;
}