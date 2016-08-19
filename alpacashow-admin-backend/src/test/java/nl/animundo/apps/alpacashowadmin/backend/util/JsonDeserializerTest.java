package nl.animundo.apps.alpacashowadmin.backend.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.junit.Test;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-8-2016.
 */
public class JsonDeserializerTest {

    @Test
    public void jsonToObject() throws IOException {

        String json = "{"
                + "   \"name\": \"Test showEvent to Json\",     "
                + "   \"date\": \"01-05-2017\",                 "
                + "   \"closeDate\": \"15-03-2017\",            "
                + "   \"location\": \"Surhuisterveen\",         "
                + "   \"judge\": \"Test Judge\",                "
                + "   \"participants\": [],                     "
                + "   \"show\":                                 "
                + "      [ {                                    "
                + "      \"showType\": \"FLEECESHOW\"},         "
                + "      {\"showType\": \"HALTERSHOW\"          "
                + "      } ]                                    "
                + "   }                                         ";

//        ShowEvent event = new ObjectMapper().readValue(json, ShowEvent.class);
//
//        LocalDate expectedDate = LocalDate.of(2017, 5, 1);
//        LocalDate expectedCloseDate = LocalDate.of(2017, 3, 15);
//
//        assertEquals(expectedDate, event.getDate());
//        assertEquals(expectedCloseDate, event.getCloseDate());
    }
}
