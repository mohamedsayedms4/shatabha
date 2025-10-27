//package org.example.demo_11.eunms.ceiling;
//
//
//import org.example.demo_11.model.Price;
//
//public class MagneticTrackStrategy implements CeilingPriceStrategy {
//    private final Price price;
//
//    public MagneticTrackStrategy(Price price) {
//        this.price = price;
//    }
//
//    @Override
//    public Long calculatePrice(Double area, Double perimeter) {
//        return safeAdd(price.getCeilingPrices().getMagneticTrackMaterials(), price.getMagneticTrackLabor());
//    }
//
//    private Long safeAdd(Long materials, Long labor) {
//        long m = materials != null ? materials : 0L;
//        long l = labor != null ? labor : 0L;
//        return m + l;
//    }
//}
