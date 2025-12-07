package org.example.demo_11.controller;

import org.example.demo_11.model.Price;
import org.example.demo_11.service.impl.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prices")
@CrossOrigin(origins = "*")
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * ✅ جلب السعر بالـ ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Price> getPrice(@PathVariable Long id) {
        return priceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * ✅ جلب السعر الافتراضي
     */
    @GetMapping
    public ResponseEntity<Price> getDefaultPrice() {
        return ResponseEntity.ok(priceService.getOrCreateDefault());
    }

    /**
     * ✅ تحديث جزئي ذكي
     * - بيحدث الحقول اللي فيها قيم بس (اللي مش null)
     * - حتى لو جوه embedded objects، بيحدث الحقل المعبي بس
     * - الحقول الفاضية (null) بتتسيب زي ما هي في الداتابيز
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Price> partialUpdatePrice(
            @PathVariable Long id,
            @RequestBody Price updates
    ) {
        try {
            Price updated = priceService.partialUpdate(id, updates);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * ✅ إنشاء سعر جديد
     */
    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {
        return ResponseEntity.ok(priceService.save(price));
    }
}