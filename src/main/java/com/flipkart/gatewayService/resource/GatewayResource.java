package com.flipkart.gatewayService.resource;

import com.flipkart.gateway.core.Gateway;
import com.flipkart.gatewayService.model.GatewayRequest;
import com.google.gson.Gson;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by praveenkumar.g on 10/08/16.
 */
@Slf4j
@Path("/gatewayService")
@Produces(MediaType.APPLICATION_JSON)
public class GatewayResource {
    private final Gson gson = new Gson();
    private final Gateway gateway;

    @Inject
    public GatewayResource(Gateway gateway) {
        this.gateway = gateway;
    }

    /**
     * It adds the metadata to rawStore and metaStore and enqueues the request to kafka.
     * @param gatewayRequest
     * @return
     */
    @POST
    @Path("/enqueue")
    @Produces({MediaType.APPLICATION_JSON})
    public Response enqueue(GatewayRequest gatewayRequest){
        try {
            String requestId = gateway.enqueue(gatewayRequest.getFile(),gatewayRequest.getMetadata());
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(requestId).build();
        } catch (Exception e) {
            log.error("INTERNAL_SERVER_ERROR while enqueuing reuest", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON_TYPE)
                    .entity("INTERNAL SERVER ERROR ENCOUNTERED").build();
        }
    }
}
