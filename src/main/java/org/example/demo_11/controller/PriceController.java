package org.example.demo_11.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.model.Price;
import org.example.demo_11.repository.PriceRepository;
import org.example.demo_11.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prices")
//@CrossOrigin("*")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final PriceRepository priceRepository;

    @PostMapping
    public ResponseEntity<Price> addPrice(@RequestBody Price price) {
        return ResponseEntity.ok(priceService.addPrice(price));
    }

    @GetMapping
    public ResponseEntity<List<Price>> getAllPrices() {
        return ResponseEntity.ok(priceRepository.findAll());
    }

    @PutMapping
    public ResponseEntity<Price> updatePrice(@RequestBody Price price) {
        return ResponseEntity.ok(priceRepository.save(price));
    }

}
