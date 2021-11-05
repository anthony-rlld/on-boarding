package com.arolland.exception;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class ExceptionMapper {

    @ServerExceptionMapper
    public RestResponse<String> mapInvalidUuidException(InvalidUuidException e) {
        return RestResponse.status(Response.Status.BAD_REQUEST, "Invalid UUID : " + e.uuid);
    }
}
