package org.example.demo_11.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.ResidentialUnitDto;
import org.example.demo_11.model.ResidentialUnit;
import org.example.demo_11.service.ResidentialUnitPriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/residential-unit")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ResidentialUnitController {

    private final ResidentialUnitPriceService residentialUnitPriceService;

    @PostMapping("/calculate")
    public ResidentialUnitDto calculateResidentialUnitPrice(@RequestBody ResidentialUnit residentialUnit) {
        return residentialUnitPriceService.calculateResidentialUnitPrice(residentialUnit);
    }
}