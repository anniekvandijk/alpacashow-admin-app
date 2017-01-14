package nl.animundo.apps.alpacashowadmin.backend.deserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import java.io.IOException;

public class JsonColorClassSerializer extends JsonSerializer<ColorClass> {

    @Override
    public void serialize(ColorClass colorClass, JsonGenerator generator, SerializerProvider provider) throws IOException {

            String replace = colorClass.toString();
            String output = replace.substring(0, 1).toUpperCase() + replace.substring(1).toLowerCase();
            generator.writeString(output);
    }
}