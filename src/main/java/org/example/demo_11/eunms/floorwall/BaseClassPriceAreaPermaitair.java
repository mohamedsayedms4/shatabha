package org.example.demo_11.eunms.floorwall;


import org.example.demo_11.model.Price;

public class BaseClassPriceAreaPermaitair {
    protected  final Price price;
    protected  final Double area;
    protected  final Double perimeter;

    public BaseClassPriceAreaPermaitair(Price price, Double area, Double perimeter) {
        this.price = price;
        this.area = area;
        this.perimeter = perimeter;
    }
}
