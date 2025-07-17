package com.data.session07.service.impl;

import com.data.session07.model.entity.Seed;
import com.data.session07.reponsitory.SeedRepository;
import com.data.session07.service.SeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeedServiceImpl implements SeedService {

    private final SeedRepository seedRepository;

    @Override
    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public Seed getSeedById(Long id) {
        return seedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giống có id: " + id));
    }

    @Override
    public Seed addSeed(Seed seed) {
        return seedRepository.save(seed);
    }

    @Override
    public Seed updateSeed(Long id, Seed updatedSeed) {
        Seed existingSeed = getSeedById(id);
        existingSeed.setSeedName(updatedSeed.getSeedName());
        existingSeed.setQuantity(updatedSeed.getQuantity());
        return seedRepository.save(existingSeed);
    }

    @Override
    public void deleteSeed(Long id) {
        if (!seedRepository.existsById(id)) {
            throw new RuntimeException("Không tồn tại giống có id: " + id);
        }
        seedRepository.deleteById(id);
    }
}
