package com.data.session02.service;

import com.data.session02.entity.Showtime;
import com.data.session02.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ShowtimeService implements IService<Showtime> {

    private final ShowtimeRepository showtimeRepository;

    @Override
    public Showtime save(Showtime entity) {
        return showtimeRepository.save(entity);
    }

    @Override
    public Optional<Showtime> findById(Long id) {
        return showtimeRepository.findById(id);
    }

    @Override
    public Showtime update(Long id, Showtime entity) {
        return showtimeRepository.findById(id)
                .map(existing -> {
                    entity.setId(id);
                    return showtimeRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
    }

    @Override
    public void delete(Long id) {
        if (!showtimeRepository.existsById(id)) {
            throw new RuntimeException("Showtime not found");
        }
        showtimeRepository.deleteById(id);
    }

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

}

