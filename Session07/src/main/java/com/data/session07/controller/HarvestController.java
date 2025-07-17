package com.data.session07.controller;

import com.data.session07.model.entity.Harvest;
import com.data.session07.service.HarvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/harvests")
@RequiredArgsConstructor
public class HarvestController {

    private final HarvestService harvestService;

    @GetMapping
    public ResponseEntity<List<Harvest>> getAllHarvests() {
        return ResponseEntity.ok(harvestService.getAllHarvests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Harvest> getHarvestById(@PathVariable Long id) {
        return ResponseEntity.ok(harvestService.getHarvestById(id));
    }

    @PostMapping
    public ResponseEntity<Harvest> addHarvest(@RequestBody Harvest harvest) {
        return ResponseEntity.ok(harvestService.addHarvest(harvest));
    }
}