package nl.animundo.apps.alpacashowadmin.backend.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonDateDeserializer extends JsonDeserializer<LocalDate> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        String incommingDateString = parser.getText();
        LocalDate tmpDate = LocalDate.parse(incommingDateString, formatter);
        return LocalDate.of(tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDayOfMonth());
    }
}