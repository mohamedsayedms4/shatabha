package org.example.demo_11.eunms.exhaust;


import org.example.demo_11.model.Price;

public class NoneExhaustStrategy implements ExhaustPriceStrategy {

    private final Price price;

    public NoneExhaustStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return 0L; // لا يوجد سعر للخيار NONE
    }
}
