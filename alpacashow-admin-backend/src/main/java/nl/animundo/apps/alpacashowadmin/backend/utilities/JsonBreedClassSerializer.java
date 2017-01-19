package nl.animundo.apps.alpacashowadmin.backend.utilities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;

import java.io.IOException;

public class JsonBreedClassSerializer extends JsonSerializer<BreedClass> {

    @Override
    public void serialize(BreedClass breedClass, JsonGenerator generator, SerializerProvider provider) throws IOException {

            String replace = breedClass.toString();
            String output = replace.substring(0, 1).toUpperCase() + replace.substring(1).toLowerCase();
            generator.writeString(output);
    }
}