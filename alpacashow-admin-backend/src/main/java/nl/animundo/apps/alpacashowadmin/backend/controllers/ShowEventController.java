package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * Created by Anniek van Dijk on 6-8-2016.
 */

@Path("/showevent")
public class ShowEventController {
    private static Logger logger = LoggerFactory.getLogger(ShowEventController.class);

    // TODO Make environment configurable
    private String environment = "dev";
    private ShowEventRepository showEventRepo;

    /*
    Jetty Runner path http://localhost:8080/alpacashow-admin-app/alpacashow-admin-backend/webservice/showevent/
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getShowEvents() throws IOException {
        loadRepository();
        Collection<ShowEvent> listOfShowEvents=showEventRepo.getAllShowEvents();
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(listOfShowEvents);
    }

    @GET
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getShowEventByKey(@PathParam("key") String key) throws IOException {
        loadRepository();
        ShowEvent event = showEventRepo.getShowEventsByKeySet(key);
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(event);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addShowEvent(ShowEvent showEvent) throws IOException {
        loadRepository();
        this.showEventRepo.add(showEvent);
    }

    @PUT
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateShowEvent(@PathParam("key") String key) throws IOException {
//        loadRepository();
//        ShowEvent showEventToUpdate = showEventRepo.getShowEventsByKeySet(key);
//        showEventToUpdate.setName("name");
//        showEventToUpdate.setDate();
//        showEventToUpdate.setJudge("judge");
//        showEventRepo.add(showEventToUpdate);
    }

    @DELETE
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteShowEvent(@PathParam("key") String key) throws IOException {
        loadRepository();
        this.showEventRepo.delete(key);

    }

    private void loadRepository() throws IOException {

        showEventRepo = ApplicationRepositoryService.getShowEventRepository(environment);
    }
}
