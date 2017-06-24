package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api (value="Showevents")
@Path("showevents")
public class ShowEventController {

    // Todo: check if new or changed showevent data is after today.
    // This can not be validated in the ShowEvent class, because you then can't handle histroic data.

    private static Logger logger = LoggerFactory.getLogger(ShowEventController.class);
    private RepositoryContext context;
    private ApplicationRepositoryService service;

    public ShowEventController(RepositoryContext context)
    {
        this.context = context;
        service = new ApplicationRepositoryService();
    }

    @GET
    @ApiOperation(value = "Get all showevents",
            response = ShowEvent.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowEvents() throws IOException {
        loadRepository();
        List<ShowEvent> listOfShowEvents=context.showEventRepository.getAllShowEventsSorted();
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
    @Path("/{id}")
    @ApiOperation(value = "Get showevent by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Show not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowEventById(@PathParam("id") String id) throws IOException {
        loadRepository();
        ShowEvent event = context.showEventRepository.getShowEventById(id);

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
            String showEventId = context.showEventRepository.add(event);
            saveRepository();
            return Response.status(Response.Status.OK).entity("Added showevent with id '" + showEventId + "'").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @ApiOperation(value = "Update showevent by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Show not found"),
            @ApiResponse(code = 400, message = "Bad request")})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateShowEvent(@PathParam("id") String id, String showEvent) throws IOException {
        loadRepository();
        String showDelete = context.showEventRepository.delete(id);
        if (showDelete == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Showevent with id '" + id + "' not found").build();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            ShowEvent event = null;
            try {
                event = mapper.readValue(showEvent, ShowEvent.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (event != null) {
                String showEventKey = context.showEventRepository.add(event);
                saveRepository();
                return Response.status(Response.Status.OK).entity("Updated showevent with id '" + showEventKey + "'").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
    }

    @DELETE
    @ApiOperation(value = "Delete showevent by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Show not found") })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteShowEvent(@PathParam("id") String id) throws IOException {
        loadRepository();
        String showDelete = context.showEventRepository.delete(id);
        if (showDelete != null) {
            saveRepository();
            return Response.status(Response.Status.OK).entity("Deleted showevent with id '" + id + "'").build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).entity("Showevent with id '" + id + "' not found").build();
        }
    }

    private void loadRepository() throws IOException {
        context.showEventRepository = service.loadShowEventRepository();
    }

    private void saveRepository() throws IOException {
        service.saveShowEventRepository();
    }
}
