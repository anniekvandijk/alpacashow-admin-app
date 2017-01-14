package nl.animundo.apps.alpacashowadmin.backend.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeSexClass;

import java.io.IOException;

public class JsonAgeSexClassDeserializer extends JsonDeserializer<AgeSexClass> {

    @Override
    public AgeSexClass deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        String incommingString = parser.getText();
        String output = incommingString.toUpperCase();
        return AgeSexClass.valueOf(output);
    }
}