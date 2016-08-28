package nl.animundo.apps.alpacashowadmin.backend.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;

import java.io.IOException;

public class JsonShowTypeDeserializer extends JsonDeserializer<ShowType> {


    @Override
    public ShowType deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        String incommingString = parser.getText();
        String replace = incommingString.replace(" ", "_");
        String output = replace.toUpperCase();
        ShowType showType = ShowType.valueOf(output);
        return showType;

    }
}