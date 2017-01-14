package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Api (value="Participants")
@Path("participants")
public class ParticipantController {

    private static Logger logger = LoggerFactory.getLogger(ParticipantController.class);
    private ParticipantRepository participantRepository;

    @GET
    @ApiOperation(value = "Get all participants",
            response = Participant.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParticipants() throws IOException {
        loadRepository();
        Collection<Participant> listOfParticipants = participantRepository.getAllParticipants();
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
    @Path("/{key}")
    @ApiOperation(value = "Get participant by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Participant not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParticipantByKey(@PathParam("key") String key) throws IOException {
        loadRepository();
        Participant participant = participantRepository.getParticipantByKeySet(key);

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
        loadRepository();
        ObjectMapper mapper = new ObjectMapper();
        Participant event = null;
        try {
            event = mapper.readValue(participant, Participant.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (event != null) {
            participantRepository.add(event);
            saveRepository();
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @ApiOperation(value = "Update participant by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Participant not found"),
            @ApiResponse(code = 400, message = "Bad request")})
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateParticipant(@PathParam("key") String key, String participant) throws IOException {
        loadRepository();
        String participantDelete = participantRepository.delete(key);
        if (participantDelete == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            Participant event = null;
            try {
                event = mapper.readValue(participant, Participant.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (event != null) {
                participantRepository.add(event);
                saveRepository();
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
    }

    @DELETE
    @ApiOperation(value = "Delete participant by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Participant not found") })
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteParticipant(@PathParam("key") String key) throws IOException {
        loadRepository();
        String participantDelete = participantRepository.delete(key);
        if (participantDelete != null) {
            saveRepository();
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private void loadRepository() throws IOException {

        participantRepository = ApplicationRepositoryService.loadParticipantRepository();
    }

    private void saveRepository() throws IOException {

        ApplicationRepositoryService.saveParticipantRepository(participantRepository);
    }
}
