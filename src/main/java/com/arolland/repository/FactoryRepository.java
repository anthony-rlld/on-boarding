package com.arolland.repository;

import com.arolland.entity.Factory;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class FactoryRepository implements ReactivePanacheMongoRepositoryBase<Factory, UUID> {
}
