package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.SortedSet;

@Api (value="Fleece Weight Points")
@Path("fleeceweightpoints")
public class FleeceWeightPointsController {

    private static Logger logger = LoggerFactory.getLogger(FleeceWeightPointsController.class);
    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private FleeceWeightPointsRepository fleeceWeightPointsRepository;

    @GET
    @ApiOperation(value = "Get all fleeece weight points",
            response = FleeceWeightPoints.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFleeceWeightPoints() throws IOException {
        loadRepository();
        SortedSet<FleeceWeightPoints> listOfFleeceWeightPoints = fleeceWeightPointsRepository.getAllFleeceWeightPoints();
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(listOfFleeceWeightPoints);
        Response response = Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With")
                .entity(json)
                .build();
        return response;
    }

    private void loadRepository() throws IOException {

        fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();
    }

}
