package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.services.ConvertFileToCsvService;
import java.io.IOException;

public class ApplicationFileDirService {

    public String getFilePath(String resource) throws IOException {

        String path = ApplicationFileDirService.class.getClassLoader().getResource(resource).getPath();
        return path;
    }
}
