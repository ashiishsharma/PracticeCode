package com.ashish.rest.resource;

import com.ashish.BlockChain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class BlockChainResource {

    private final BlockChain blockChain;

    public BlockChainResource(){
        blockChain = new BlockChain();
    }

    @GET
    @Path("mine")
//    @Produces(MediaType.TEXT_PLAIN)
    public Response getMine(@Context HttpHeaders headers, String body) {
        return Response.status(200).entity("Blockchain mining to be implemented").build();
    }

    @POST
    @Path("transactions/new")
//    @Produces(MediaType.TEXT_PLAIN)
    public Response postNewTransaction(@Context HttpHeaders headers, String body) {
        return Response.status(200).entity("New transaction to be implemented").build();
    }

    @GET
    @Path("chain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFullChain(@Context HttpHeaders headers, String body){
        String blockChainJson = StringUtils.EMPTY;
        try{
            blockChainJson = getBlockChainJson();
        } catch (JsonProcessingException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
        return Response.status(200).entity(blockChainJson).build();
    }

    private String getBlockChainJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String blockChainJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(blockChain.getChain());
        return blockChainJson;
    }
}