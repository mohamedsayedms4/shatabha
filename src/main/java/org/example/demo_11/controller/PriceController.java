package org.example.demo_11.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.model.Price;
import org.example.demo_11.service.impl.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prices")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

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
     * ✅ تحديث ذكي - يدعم تحديث حقول مفردة
     * يمكن إرسال:
     * - حقل عادي: {"coldInsulationForFloors": 300}
     * - حقل في كائن مضمن: {"windowPrices": {"alumetalPsMaterials": 250}}
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Price> smartUpdatePrice(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates
    ) {
        try {
            Price updated = priceService.smartUpdate(id, updates);
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