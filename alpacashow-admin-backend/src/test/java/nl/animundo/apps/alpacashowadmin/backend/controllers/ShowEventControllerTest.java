package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.animundo.apps.alpacashowadmin.backend.domain.Show;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowType;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-8-2016.
 */
public class ShowEventControllerTest {

    // TODO client installeren om de webserver goed te testen

    @Test
    public void getShowEvent () throws JsonProcessingException {

        String name = "Test showEvent to Json";
        LocalDate date = LocalDate.of(2017, 5, 1);
        LocalDate closeDate = LocalDate.of(2017, 3, 15);
        String location = "Surhuisterveen";
        String judge = "Test Judge";
        Set<Show> shows = new HashSet<>();
        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(showEvent);

        String expectedJson = "{"
                + "   \"name\": \"Test showEvent to Json\",     "
                + "   \"date\": \"2017-05-01\",                 "
                + "   \"closeDate\": \"2017-03-15\",            "
                + "   \"location\": \"Surhuisterveen\",         "
                + "   \"judge\": \"Test Judge\",                "
                + "   \"participants\": [],                     "
                + "   \"show\":                                 "
                + "      [ {                                    "
                + "      \"showType\": \"FLEECESHOW\"},         "
                + "      {\"showType\": \"HALTERSHOW\"          "
                + "      } ]                                    "
                + "   }                                         ";

        String jsonTrim = json.replaceAll("\\s","");
        String expectedJsonTrim = expectedJson.replaceAll("\\s","");

  //      assertEquals(expectedJsonTrim, jsonTrim);


    }

    @Test
    public void addShowEvent() {
        String json = "{"
                + "   \"name\": \"Test from Json2017\",  "
                + "   \"date\": \"01-05-2017\",          "
                + "   \"closeDate\": \"15-03-2017\",     "
                + "   \"location\": \"Test\",            "
                + "   \"judge\": \"judge Y\",            "
                + "   \"show\":                          "
                + "      [ {                             "
                + "      \"showType\": \"HALTERSHOW\"    "
                + "      } ]                             "
                + "   }                                  ";
    }
}
