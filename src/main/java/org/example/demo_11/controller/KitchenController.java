package org.example.demo_11.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.KitchenDto;
import org.example.demo_11.model.Kitchen;
import org.example.demo_11.service.KitchenPriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kitchen")
@CrossOrigin("*")
@RequiredArgsConstructor
public class KitchenController {

    private final KitchenPriceService kitchenPriceService;

    @PostMapping("/calculate")
    public KitchenDto calculateKitchenPrice(@RequestBody Kitchen kitchen) {
        return kitchenPriceService.calculateKitchenPrice(kitchen);
    }
}
