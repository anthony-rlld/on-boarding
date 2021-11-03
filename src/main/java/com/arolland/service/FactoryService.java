package com.arolland.service;

import com.arolland.repository.FactoryRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FactoryService {

    @Inject
    FactoryRepository factoryRepository;

    public Uni<?> getAll() {
        return factoryRepository.listAll();
    }
}
