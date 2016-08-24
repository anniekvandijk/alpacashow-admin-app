package nl.animundo.apps.alpacashowadmin.backend.services.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by Anniek van Dijk on 24-8-2016.
 */
public class ApplicationIDGenerator {

    private static Logger logger = LoggerFactory.getLogger(ApplicationIDGenerator.class);

    public static String generateID () {
        UUID id = UUID.randomUUID();
        logger.info("Generated id '" + id + "'");
        return String.valueOf(id);
    }
}
