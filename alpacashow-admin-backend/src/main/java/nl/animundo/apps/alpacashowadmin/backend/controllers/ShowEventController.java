package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Anniek van Dijk on 6-8-2016.
 */

@Path("/showevent")
public class ShowEventController {
    private static Logger logger = LoggerFactory.getLogger(ShowEventController.class);
    private ShowEventRepository showEventRepo;

    // TODO Make environment configurable
    private String environment = "dev";


    private void loadRepository() throws IOException {

        showEventRepo = ApplicationRepositoryService.getShowEventRepository(environment);
    }

    /*
    Jetty Runner path http://localhost:8080/alpacashow-admin-app/alpacashow-admin-backend/webservice/showevent/
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ShowEvent> getShowEvents() throws IOException {
        loadRepository();
        Collection<ShowEvent> listOfShowEvents=showEventRepo.getAllShowEvents();
        logger.info("Getting showevents");
        return listOfShowEvents;
    }

    @GET
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShowEvent getShowEventByKey(@PathParam("key") String key) throws IOException {
        loadRepository();
        return showEventRepo.getShowEventsByKeySet(key);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addShowEvent(ShowEvent showEvent) throws IOException {
        loadRepository();
        this.showEventRepo.add(showEvent);
    }

    @DELETE
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteShowEvent(@PathParam("key") String key) throws IOException {
        loadRepository();
        this.showEventRepo.delete(key);

    }
}
