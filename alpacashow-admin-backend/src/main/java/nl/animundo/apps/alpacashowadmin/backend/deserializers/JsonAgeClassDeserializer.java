package nl.animundo.apps.alpacashowadmin.backend.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import java.io.IOException;

public class JsonAgeClassDeserializer extends JsonDeserializer<AgeClass> {

    @Override
    public AgeClass deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        String incommingString = parser.getText();
        String output = incommingString.toUpperCase();
        return AgeClass.valueOf(output);
    }
}