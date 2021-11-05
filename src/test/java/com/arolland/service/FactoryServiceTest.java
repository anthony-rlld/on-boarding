package com.arolland.service;

import com.arolland.entity.Factory;
import com.arolland.repository.FactoryRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@QuarkusTest
public class FactoryServiceTest {

    @InjectMock
    protected FactoryRepository factoryMockRepository;

    @Inject
    FactoryService factoryService;

    private List<Factory> factoryDataList;
    private Factory factory1;

    @BeforeEach
    void beforeEach() {
        factory1 = new Factory();
        factory1.setId(UUID.randomUUID());
        Factory factory2 = new Factory();
        factory2.setId(UUID.randomUUID());
        factoryDataList = List.of(factory1, factory2);
    }

    @Test
    public void testGetAll() {
        Mockito.when(factoryMockRepository.listAll())
                .thenReturn(Uni.createFrom().item(factoryDataList));

        Uni<List<Factory>> factoryPendingRes = factoryService.getAll();

        List<Factory> factoryResList = factoryPendingRes.await().indefinitely();
        Assertions.assertEquals(factoryDataList.size(), factoryResList.size());
    }

    @Test
    public void testGetById_notExistUUID_failEmptyObject() {
        UUID notExistUuid = UUID.randomUUID();

        Mockito.when(factoryMockRepository.findById(notExistUuid))
                .thenReturn(Uni.createFrom().nullItem());

        Uni<Factory> factoryPendingRes = factoryService.getById(notExistUuid);

        Factory factoryRes = factoryPendingRes.await().indefinitely();
        Assertions.assertNull(factoryRes);
    }

    @Test
    public void testGetById_findOne() {
        Mockito.when(factoryMockRepository.findById(factory1.getId()))
                .thenReturn(Uni.createFrom().item(factory1));

        Uni<Factory> factoryPendingRes = factoryService.getById(factory1.getId());

        Factory factoryRes = factoryPendingRes.await().indefinitely();
        Assertions.assertEquals(factory1, factoryRes);
    }
}
