package org.example.demo_11.service;


import org.example.demo_11.model.Price;

public interface PriceService {

    Price addPrice(Price price);
    Price getPriceById(Long id);
}
