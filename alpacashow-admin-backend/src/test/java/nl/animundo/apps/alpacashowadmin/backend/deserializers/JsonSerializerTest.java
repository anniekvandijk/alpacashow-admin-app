package nl.animundo.apps.alpacashowadmin.backend.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.Test;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-8-2016.
 */
public class JsonSerializerTest {

    @Test
    public void ObjectToJson() throws IOException {

        String id = "c6947908-830d-4c10-ac0a-042f044f7a41";
        String name = "Test showEvent to Json";
        LocalDate date = LocalDate.of(2017, 5, 1);
        LocalDate closeDate = LocalDate.of(2017, 3, 15);
        String location = "Surhuisterveen";
        String judge = "Test Judge";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);

        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(showEvent);
        String jsonTrim = json.replaceAll("\\s", "");

        String expectedJson = "{"
                + "   \"name\": \"Test showEvent to Json\",     "
                + "   \"date\": \"2017-05-01\",                 "
                + "   \"closeDate\": \"2017-03-15\",            "
                + "   \"location\": \"Surhuisterveen\",         "
                + "   \"judge\": \"Test Judge\",                "
                + "   \"showType\": \"Fleeceshow\",             "
                + "   \"participants\": []                      "
                + "   }                                         ";
        String expectedJsonTrim = expectedJson.replaceAll("\\s", "");

        assertEquals(expectedJsonTrim, jsonTrim);
    }
}
