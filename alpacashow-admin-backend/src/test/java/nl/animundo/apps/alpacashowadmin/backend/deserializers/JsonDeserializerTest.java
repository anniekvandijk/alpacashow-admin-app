package nl.animundo.apps.alpacashowadmin.backend.deserializers;

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
                + "   \"date\": \"2017-05-01\",                 "
                + "   \"closeDate\": \"2017-03-15\",            "
                + "   \"location\": \"Surhuisterveen\",         "
                + "   \"judge\": \"Test Judge\",                "
                + "   \"showType\": \"Haltershow\",             "
                + "   \"participants\": []                      "
                + "   }                                         ";

        ShowEvent event = new ObjectMapper().readValue(json, ShowEvent.class);

        LocalDate expectedDate = LocalDate.of(2017, 5, 1);
        LocalDate expectedCloseDate = LocalDate.of(2017, 3, 15);

        assertEquals("Test showEvent to Json", event.getName());
        assertEquals(expectedDate, event.getDate());
        assertEquals(expectedCloseDate, event.getCloseDate());
    }
}
