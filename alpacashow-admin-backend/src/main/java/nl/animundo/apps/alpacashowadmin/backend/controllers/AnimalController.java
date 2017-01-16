package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Api (value="Animals")
@Path("animals")
public class AnimalController {

    private static Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private AnimalRepository animalRepository;

    public AnimalController (AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // TODO: if response != 200, put some information in the response body what went wrong.

    @GET
    @ApiOperation(value = "Get all animals",
            response = Animal.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnimals() throws IOException {
        loadRepository();
        Collection<Animal> listOfAnimals = animalRepository.getAllAnimals();
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(listOfAnimals);
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
    @ApiOperation(value = "Get animal by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Animal not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnimalByKey(@PathParam("key") String key) throws IOException {
        loadRepository();
        Animal animal = animalRepository.getAnimalByKeySet(key);

        if (animal != null) {
            return Response.status(Response.Status.OK).entity(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(animal)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @ApiOperation(value = "Add new animal",
            response = Animal.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request")})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAnimal(String animal) throws IOException {
        loadRepository();
        ObjectMapper mapper = new ObjectMapper();
        Animal event = null;
        try {
            event = mapper.readValue(animal, Animal.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (event != null) {
            animalRepository.add(event);
            saveRepository();
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @ApiOperation(value = "Update animal by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Animal not found"),
            @ApiResponse(code = 400, message = "Bad request")})
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAnimal(@PathParam("key") String key, String animal) throws IOException {
        loadRepository();
        String animalDelete = animalRepository.delete(key);
        if (animalDelete == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            Animal event = null;
            try {
                event = mapper.readValue(animal, Animal.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (event != null) {
                animalRepository.add(event);
                saveRepository();
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
    }

    @DELETE
    @ApiOperation(value = "Delete animal by key")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Animal not found") })
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAnimal(@PathParam("key") String key) throws IOException {
        loadRepository();
        String animalDelete = animalRepository.delete(key);
        if (animalDelete != null) {
            saveRepository();
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private void loadRepository() throws IOException {

        animalRepository = service.loadAnimalRepository();
    }

    private void saveRepository() throws IOException {

        service.saveAnimalRepository();
    }
}
