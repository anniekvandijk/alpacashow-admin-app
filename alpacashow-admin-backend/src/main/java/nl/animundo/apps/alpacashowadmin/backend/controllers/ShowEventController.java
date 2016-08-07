package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

// /alpacashow-admin-app/backend/webservice/showevent/

    ShowEventRepository showEvent = new CsvShowEventRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ShowEvent> getShowEvents()
    {

        Collection<ShowEvent> listOfShowEvents=showEvent.getAllShowEvents();
        logger.info("Getting showevents");
        return listOfShowEvents;
    }

    @GET
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShowEvent getShowEventByKey(@PathParam("key") String key)
    {
        return showEvent.getShowEventsByKeySet(key);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addShowEvent(ShowEvent showEvent)
    {
        this.showEvent.add(showEvent);
    }

    @DELETE
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteShowEvent(@PathParam("key") String key)
    {
        this.showEvent.delete(key);

    }
}