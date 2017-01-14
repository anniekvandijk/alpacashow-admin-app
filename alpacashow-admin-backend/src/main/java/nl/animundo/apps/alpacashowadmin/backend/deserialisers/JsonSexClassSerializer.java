package nl.animundo.apps.alpacashowadmin.backend.deserialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;

import java.io.IOException;

public class JsonSexClassSerializer extends JsonSerializer<SexClass> {

    @Override
    public void serialize(SexClass sexClass, JsonGenerator generator, SerializerProvider provider) throws IOException {

            String replace = sexClass.toString();
            String output = replace.substring(0, 1).toUpperCase() + replace.substring(1).toLowerCase();
            generator.writeString(output);
    }
}