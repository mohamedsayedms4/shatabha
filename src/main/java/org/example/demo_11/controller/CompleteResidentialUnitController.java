package org.example.demo_11.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.CompleteResidentialUnitDto;
import org.example.demo_11.model.ResidentialUnit;
import org.example.demo_11.service.CompleteResidentialUnitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/residential-units/price")
//@CrossOrigin("*")
@RequiredArgsConstructor
public class CompleteResidentialUnitController {

    private final CompleteResidentialUnitService completeResidentialUnitService;

    @PostMapping()
    public CompleteResidentialUnitDto calculateCompleteUnitPrice(@RequestBody ResidentialUnit unit) {
        return completeResidentialUnitService.calculateCompleteUnitPrice(unit);
    }
}