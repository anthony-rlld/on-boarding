package com.arolland.repository;

import com.arolland.entity.FactoryEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class FactoryRepository implements ReactivePanacheMongoRepositoryBase<FactoryEntity, UUID> {
}
