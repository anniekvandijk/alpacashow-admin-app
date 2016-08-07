package nl.animundo.apps.alpacashowadmin.backend.services.application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationPropertiesServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getDevProperties() throws IOException {

        Properties prop = new Properties(ApplicationPropertiesService.getApplicationProperties("dev"));

        assertEquals("/src/test/resources/csv/SHOWEVENTS.csv", prop.getProperty("csv-showevent-filedir"));

    }

    @Test
    public void getPrdProperties() throws IOException {

        Properties prop = ApplicationPropertiesService.getApplicationProperties("prd");

        assertEquals("/src/main/resources/csv/SHOWEVENTS.csv", prop.getProperty("csv-showevent-filedir"));

    }

    @Test
    public void getNotKnownEnvProperties() throws IOException {

        Properties prop = ApplicationPropertiesService.getApplicationProperties("bla");

        assertEquals("/src/test/resources/csv/SHOWEVENTS.csv", prop.getProperty("csv-showevent-filedir"));

    }


}
