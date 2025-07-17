package com.data.session07.controller;

import com.data.session07.model.entity.Seed;
import com.data.session07.service.SeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seeds")
@RequiredArgsConstructor
public class SeedController {

    private final SeedService seedService;

    @GetMapping
    public ResponseEntity<List<Seed>> getAllSeeds() {
        return ResponseEntity.ok(seedService.getAllSeeds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seed> getSeedById(@PathVariable Long id) {
        return ResponseEntity.ok(seedService.getSeedById(id));
    }

    @PostMapping
    public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) {
        return ResponseEntity.ok(seedService.addSeed(seed));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seed> updateSeed(@PathVariable Long id, @RequestBody Seed seed) {
        return ResponseEntity.ok(seedService.updateSeed(id, seed));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeed(@PathVariable Long id) {
        seedService.deleteSeed(id);
        return ResponseEntity.noContent().build();
    }
}
