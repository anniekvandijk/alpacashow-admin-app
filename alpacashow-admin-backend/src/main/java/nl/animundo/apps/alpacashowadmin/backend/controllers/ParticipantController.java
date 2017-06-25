package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.core.InjectParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Api (value="Participants")
@Path("participants")
public class ParticipantController {

    private static Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private RepositoryContext context;
    private ApplicationRepositoryService service;

    @Inject
    public ParticipantController() throws IOException {
        context = new RepositoryContext();
        service = new ApplicationRepositoryService(context);
        service.loadParticipantRepository();
    }

    // TODO: if response != 200, put some information in the response body what went wrong.

    @GET
    @ApiOperation(value = "Get all participants",
            response = Participant.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParticipants() throws IOException {
        List<Participant> listOfParticipants = context.participantRepository.getAllParticipantsSorted();
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(listOfParticipants);
        Response response = Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With")
                .entity(json)
                .build();
        return response;
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Get participant by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Participant not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParticipantById(@PathParam("id") String id) throws IOException {
        Participant participant = context.participantRepository.getParticipantById(id);
        if (participant != null) {
            return Response.status(Response.Status.OK).entity(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(participant)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @ApiOperation(value = "Add new participant",
            response = Participant.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request")})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addParticipant(String participant) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Participant event = null;
        try {
            event = mapper.readValue(participant, Participant.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (event != null) {
            Participant addedParticipant = context.participantRepository.add(event);
            saveRepository();
            return Response.status(Response.Status.OK).entity(addedParticipant).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @ApiOperation(value = "Update participant by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Participant not found"),
            @ApiResponse(code = 400, message = "Bad request")})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateParticipant(@PathParam("id") String id, String participant) throws IOException {
        Participant getParticipantToUpdate = context.participantRepository.getParticipantById(id);
        if (getParticipantToUpdate == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            Participant participantToUpdate = null;
            try {
                participantToUpdate = mapper.readValue(participant, Participant.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (participantToUpdate != null) {
                Participant updatedParticipant = context.participantRepository.update(id, participantToUpdate);
                saveRepository();
                return Response.status(Response.Status.OK).entity(updatedParticipant).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
    }

    @DELETE
    @ApiOperation(value = "Delete participant by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Participant not found") })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteParticipant(@PathParam("id") String id) throws IOException {
        Participant getParticipantDelete = context.participantRepository.getParticipantById(id);
        if (getParticipantDelete != null) {
            String deletedParticipant = context.participantRepository.delete(id);
            saveRepository();
            return Response.status(Response.Status.OK).entity(deletedParticipant).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private void saveRepository() throws IOException {

        service.saveParticipantRepository();
    }
}
