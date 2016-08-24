package nl.animundo.apps.alpacashowadmin.backend.services.application;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

/**
 * Created by Anniek van Dijk on 24-8-2016.
 */
public class ApplicationIDGeneratorTest {

    private static Logger logger = LoggerFactory.getLogger(ApplicationIDGeneratorTest.class);

    @Test
    public void generateUniqueID() {

        String id = ApplicationIDGenerator.generateID();
        assertTrue(id !=null);
    }
}
