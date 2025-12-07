package org.example.demo_11.service.impl;

import org.example.demo_11.model.*;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Transactional
    public Price save(Price price) {
        return priceRepository.save(price);
    }

    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id);
    }

    public Price getOrCreateDefault() {
        return priceRepository.findById(1L)
                .orElseGet(() -> {
                    Price defaultPrice = new Price();
                    defaultPrice.setId(1L);
                    return priceRepository.save(defaultPrice);
                });
    }

    /**
     * ✅ دالة للتحديث الجزئي - بتحدث الحقول اللي فيها قيم بس
     * حتى لو جوه embedded objects، بتحدث الحقل المعبي بس وتسيب الباقي
     */
    @Transactional
    public Price partialUpdate(Long id, Price updates) {
        Price existing = priceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price not found with id: " + id));

        // استخدم reflection لتحديث كل الحقول
        mergeObjects(updates, existing, Price.class);

        return priceRepository.save(existing);
    }

    /**
     * ✅ دالة عامة لدمج الكائنات باستخدام Reflection
     * بتشيك على كل حقل، لو فيه قيمة (مش null) بتحدثه
     */
    private void mergeObjects(Object source, Object target, Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object sourceValue = field.get(source);

                // لو الحقل مش null في الـ source
                if (sourceValue != null) {
                    // لو الحقل ده embedded object
                    if (isEmbeddedObject(field.getType())) {
                        Object targetValue = field.get(target);

                        // لو الـ target مش فيه القيمة دي، خليه object جديد
                        if (targetValue == null) {
                            field.set(target, sourceValue);
                        } else {
                            // لو موجود، ادمج الحقول جواه
                            mergeObjects(sourceValue, targetValue, field.getType());
                        }
                    } else {
                        // لو حقل عادي، حدثه مباشرة
                        field.set(target, sourceValue);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field: " + field.getName(), e);
            }
        }
    }

    /**
     * ✅ دالة للتحقق من إن الـ class ده embedded object ولا لأ
     */
    private boolean isEmbeddedObject(Class<?> clazz) {
        return clazz == WindowPrices.class ||
                clazz == ShutterPrices.class ||
                clazz == DoorPrices.class ||
                clazz == LightingPrices.class ||
                clazz == BathroomPrices.class ||
                clazz == FloorWallPrices.class ||
                clazz == CeilingPrices.class ||
                clazz == VentilationPrices.class;
    }
}