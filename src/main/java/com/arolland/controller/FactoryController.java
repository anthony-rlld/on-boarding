package com.arolland.controller;

import com.arolland.utils.UUIDValidator;
import com.arolland.entity.Factory;
import com.arolland.service.FactoryService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getById(@PathParam("uuid") String uuid) {
        return factoryService.getById(UUIDValidator.validateFrom(uuid))
                .map(data -> (data == null) ? null : Response.ok(data).build())
                .onItem().ifNull().continueWith(Response.status(Response.Status.NOT_FOUND).build());

    }
}
