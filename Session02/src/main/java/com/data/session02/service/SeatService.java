package com.data.session02.service;

import com.data.session02.entity.Seat;
import com.data.session02.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatService implements IService<Seat> {

    private final SeatRepository seatRepository;

    @Override
    public Seat save(Seat entity) {
        return seatRepository.save(entity);
    }

    @Override
    public Optional<Seat> findById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public Seat update(Long id, Seat entity) {
        return seatRepository.findById(id)
                .map(existing -> {
                    entity.setId(id);
                    return seatRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    @Override
    public void delete(Long id) {
        if (!seatRepository.existsById(id)) {
            throw new RuntimeException("Seat not found");
        }
        seatRepository.deleteById(id);
    }

    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

}

