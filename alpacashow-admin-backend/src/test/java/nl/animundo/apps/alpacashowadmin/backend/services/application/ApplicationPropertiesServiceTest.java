package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.services.AnimalClassCodeService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationPropertiesServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        Constructor<ApplicationPropertiesService> constructor = ApplicationPropertiesService.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);

        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (InstantiationException) e.getTargetException();
        }

        constructor.setAccessible(false);

    }

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
