package com.data.session02.service;

import com.data.session02.entity.ScreenRoom;
import com.data.session02.repository.ScreenRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenRoomService implements IService<ScreenRoom> {

    private final ScreenRoomRepository screenRoomRepository;

    @Override
    public ScreenRoom save(ScreenRoom entity) {
        return screenRoomRepository.save(entity);
    }

    @Override
    public Optional<ScreenRoom> findById(Long id) {
        return screenRoomRepository.findById(id);
    }

    @Override
    public ScreenRoom update(Long id, ScreenRoom entity) {
        return screenRoomRepository.findById(id)
                .map(existing -> {
                    entity.setId(id);
                    return screenRoomRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("ScreenRoom not found"));
    }

    @Override
    public void delete(Long id) {
        if (!screenRoomRepository.existsById(id)) {
            throw new RuntimeException("ScreenRoom not found");
        }
        screenRoomRepository.deleteById(id);
    }
    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepository.findAll();
    }

}

