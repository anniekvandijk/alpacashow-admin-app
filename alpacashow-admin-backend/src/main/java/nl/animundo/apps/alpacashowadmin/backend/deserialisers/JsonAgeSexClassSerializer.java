package nl.animundo.apps.alpacashowadmin.backend.deserialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeSexClass;
import java.io.IOException;

public class JsonAgeSexClassSerializer extends JsonSerializer<AgeSexClass> {

    @Override
    public void serialize(AgeSexClass ageSexClass, JsonGenerator generator, SerializerProvider provider) throws IOException {

            String replace = ageSexClass.toString();
            String output = replace.substring(0, 1).toUpperCase() + replace.substring(1).toLowerCase();
            generator.writeString(output);
    }
}