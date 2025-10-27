package org.example.demo_11.eunms.sink;

import org.example.demo_11.model.Price;

public interface SinkPriceStrategy {
    Long calculatePrice(Price price);
}
