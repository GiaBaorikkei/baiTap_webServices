package com.data.session07.service.impl;

import com.data.session07.model.entity.Worker;
import com.data.session07.reponsitory.WorkerRepository;
import com.data.session07.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy công nhân có id: " + id));
    }

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker updateWorker(Long id, Worker updatedWorker) {
        Worker existingWorker = getWorkerById(id);
        existingWorker.setFullname(updatedWorker.getFullname());
        existingWorker.setPhone(updatedWorker.getPhone());
        existingWorker.setAddress(updatedWorker.getAddress());
        existingWorker.setSalary(updatedWorker.getSalary());
        return workerRepository.save(existingWorker);
    }

    @Override
    public void deleteWorker(Long id) {
        if (!workerRepository.existsById(id)) {
            throw new RuntimeException("Không tồn tại công nhân có id: " + id);
        }
        workerRepository.deleteById(id);
    }
}
