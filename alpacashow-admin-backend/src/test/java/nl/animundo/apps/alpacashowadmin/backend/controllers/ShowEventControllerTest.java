package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-8-2016.
 */
public class ShowEventControllerTest {

    @Test
    public void serializingLocalDate() throws JsonProcessingException {
        LocalDate date1 = LocalDate.of(2014, 12, 20);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String localDateToString = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String result = mapper.writeValueAsString(localDateToString);
        assertEquals("\"20-12-2014\"", result);
    }

    @Test
    public void deserializingLocalDate() {
        String json = "{"
           + "   \"date\": \"01-05-2017\"           "
           + "   }                                  ";

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//        LocalDate newdate = LocalDate.parse(date.format("yyyy-MM-dd"));
//      //  mapper.reader(newdate);
//
//        Dummy event = null;
//        try {
//            event = mapper.readerFor(Dummy.class).readValue(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assertEquals("01-05-2017", date.format(event.getDate()));

    }

    @Test
    public void showEvent() {
        String json = "{"
                + "   \"name\": \"Test 2017\",           "
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
