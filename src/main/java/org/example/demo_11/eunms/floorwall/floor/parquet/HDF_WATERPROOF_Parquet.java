package org.example.demo_11.eunms.floorwall.floor.parquet;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class HDF_WATERPROOF_Parquet extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {
    public HDF_WATERPROOF_Parquet(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        // التعديل: تغيير اسم الدالة إلى الأسماء الجديدة
        return safeAdd(price.getFloorWallPrices().getHdfWaterproofParquetMaterials(),
                price.getFloorWallPrices().getHdfWaterproofParquetLabor(),
                area * 1.2);
    }

    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * area);
    }
}