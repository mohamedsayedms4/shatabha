package org.example.demo_11.eunms.exhaust;


import org.example.demo_11.model.Price;

public class WindowExhaustStrategy implements ExhaustPriceStrategy {

    private final Price price;

    public WindowExhaustStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getVentilationPrices().getWindowExhaustMaterials(), price.getVentilationPrices().getWindowExhaustLabor());
    }

    private Long safeAdd(Long v1, Long v2) {
        long a = (v1 != null) ? v1 : 0L;
        long b = (v2 != null) ? v2 : 0L;
        return a + b;
    }
}
