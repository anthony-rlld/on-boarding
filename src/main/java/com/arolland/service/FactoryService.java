package com.arolland.service;

import com.arolland.entity.Factory;
import com.arolland.repository.FactoryRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class FactoryService {

    @Inject
    FactoryRepository factoryRepository;

    public Uni<List<Factory>> getAll() {
        return factoryRepository.listAll();
    }

    public Uni<Factory> getById(UUID uuid) {
        return factoryRepository.findById(uuid);
    }
}
