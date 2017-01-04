package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api (value="Showevent")
@Path("showevents")
public class ShowEventController {

    private static Logger logger = LoggerFactory.getLogger(ShowEventController.class);
    private ShowEventRepository showEventRepo;

    // TODO: if response != 200, put some information in the response body what went wrong.

    @GET
    @ApiOperation(value = "Get all Showevents",
            response = ShowEvent.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowEvents() throws IOException {
        loadRepository();
        Collection<ShowEvent> listOfShowEvents=showEventRepo.getAllShowEvents();
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(listOfShowEvents);
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
    @ApiOperation(value = "Get showevent by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Show not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowEventByKey(@PathParam("key") String key) throws IOException {
        loadRepository();
        ShowEvent event = showEventRepo.getShowEventsByKeySet(key);

        if (event != null) {
            return Response.status(Response.Status.OK).entity(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(event)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @ApiOperation(value = "Add new showevent",
            response = ShowEvent.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request")})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShowEvent(String showEvent) throws IOException {
        loadRepository();
        ObjectMapper mapper = new ObjectMapper();
        ShowEvent event = null;
        try {
            event = mapper.readValue(showEvent, ShowEvent.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (event != null) {
            showEventRepo.add(event);
            saveRepository();
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @ApiOperation(value = "Update showevent by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Show not found"),
            @ApiResponse(code = 400, message = "Bad request")})
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateShowEvent(@PathParam("key") String key, String showEvent) throws IOException {
        loadRepository();
        String showDelete = showEventRepo.delete(key);
        if (showDelete == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ObjectMapper mapper = new ObjectMapper();
        ShowEvent event = null;
        try {
            event = mapper.readValue(showEvent, ShowEvent.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (event != null) {
            showEventRepo.add(event);
            saveRepository();
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @ApiOperation(value = "Delete showevent by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Show not found") })
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteShowEvent(@PathParam("key") String key) throws IOException {
        loadRepository();
        String showDelete = showEventRepo.delete(key);
        if (showDelete != null) {
            saveRepository();
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private void loadRepository() throws IOException {

        showEventRepo = ApplicationRepositoryService.loadShowEventRepository();
    }

    private void saveRepository() throws IOException {

        ApplicationRepositoryService.saveShowEventRepository(showEventRepo);
    }
}
