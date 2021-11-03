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
import java.util.List;

@QuarkusTest
@Timeout(3000)
public class FactoryServiceTest {

    @InjectMock
    protected FactoryRepository factoryMockRepository;

    @Inject
    FactoryService factoryService;

    private List<Factory> factoryDataList;

    @BeforeEach
    void beforeEach() {
        Factory factory1 = new Factory();
        Factory factory2 = new Factory();
        factoryDataList = List.of(factory1, factory2);
    }

    @Test
    public void testFactoryService() {
        Mockito.when(factoryMockRepository.listAll())
                .thenReturn(Uni.createFrom().item(factoryDataList));

        Uni<List<Factory>> factoryPendingRes = factoryService.getAll();

        List<Factory> factoryResList = factoryPendingRes.await().indefinitely();
        Assertions.assertEquals(factoryDataList.size(), factoryResList.size());
    }
}
