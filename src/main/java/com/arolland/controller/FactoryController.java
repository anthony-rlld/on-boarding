package com.arolland.controller;

import com.arolland.entity.Factory;
import com.arolland.service.FactoryService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/factories")
public class FactoryController {

    @Inject
    FactoryService factoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Factory>> getAll() {
        return factoryService.getAll();
    }
}
