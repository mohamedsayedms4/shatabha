package org.example.demo_11.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.demo_11.model.Price;
import org.example.demo_11.repository.PriceRepository;
import org.example.demo_11.service.PriceService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public Price addPrice(Price price) {
        if (price.getId() == null || price.getId() != 1) {
            throw new IllegalArgumentException("Price ID must be 1 or a positive value.");
        }
        return priceRepository.save(price);
    }

    @Override
    public Price getPriceById(Long id) {
        return priceRepository.findById(id).orElseThrow(() -> new RuntimeException("Price row not found"));
    }
}
