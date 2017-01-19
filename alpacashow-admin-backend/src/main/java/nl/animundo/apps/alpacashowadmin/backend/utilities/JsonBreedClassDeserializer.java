package nl.animundo.apps.alpacashowadmin.backend.utilities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import java.io.IOException;

public class JsonBreedClassDeserializer extends JsonDeserializer<BreedClass> {

    @Override
    public BreedClass deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        String incommingString = parser.getText();
        String output = incommingString.toUpperCase();
        return BreedClass.valueOf(output);
    }
}