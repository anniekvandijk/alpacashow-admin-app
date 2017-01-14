package nl.animundo.apps.alpacashowadmin.backend.deserialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;

import java.io.IOException;

public class JsonShowTypeSerializer extends JsonSerializer<ShowType> {

    @Override
    public void serialize(ShowType showType, JsonGenerator generator, SerializerProvider provider) throws IOException {

            String show = showType.toString();
            String replace = show.replace("_", " ");
            String output = replace.substring(0, 1).toUpperCase() + replace.substring(1).toLowerCase();
            generator.writeString(output);
    }
}