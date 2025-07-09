package com.data.session02.service;

import com.data.session02.entity.Theater;
import com.data.session02.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TheaterService implements IService<Theater> {

    private final TheaterRepository theaterRepository;

    @Override
    public Theater save(Theater entity) {
        return theaterRepository.save(entity);
    }

    @Override
    public Optional<Theater> findById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    public Theater update(Long id, Theater entity) {
        return theaterRepository.findById(id)
                .map(existing -> {
                    entity.setId(id);
                    return theaterRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Theater not found"));
    }

    @Override
    public void delete(Long id) {
        if (!theaterRepository.existsById(id)) {
            throw new RuntimeException("Theater not found");
        }
        theaterRepository.deleteById(id);
    }

    @Override
    public List<Theater> findAll() {
        return theaterRepository.findAll();
    }

}
