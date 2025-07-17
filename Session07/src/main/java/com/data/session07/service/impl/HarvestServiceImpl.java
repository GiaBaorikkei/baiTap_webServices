package com.data.session07.service.impl;

import com.data.session07.model.entity.Harvest;
import com.data.session07.reponsitory.HarvestRepository;
import com.data.session07.service.HarvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HarvestServiceImpl implements HarvestService {

    private final HarvestRepository harvestRepository;

    @Override
    public List<Harvest> getAllHarvests() {
        return harvestRepository.findAll();
    }

    @Override
    public Harvest getHarvestById(Long id) {
        return harvestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thu hoạch có id: " + id));
    }

    @Override
    public Harvest addHarvest(Harvest harvest) {
        if (harvest.getCreatedAt() == null) {
            harvest.setCreatedAt(java.time.LocalDateTime.now());
        }
        return harvestRepository.save(harvest);
    }
}
