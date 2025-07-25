package com.data.session07.service;

import com.data.session07.model.entity.Harvest;

import java.util.List;

public interface HarvestService {
    List<Harvest> getAllHarvests();
    Harvest getHarvestById(Long id);
    Harvest addHarvest(Harvest harvest);
}
