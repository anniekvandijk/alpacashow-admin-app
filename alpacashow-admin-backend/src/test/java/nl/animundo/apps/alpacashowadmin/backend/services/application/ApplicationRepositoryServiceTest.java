package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationRepositoryServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        Constructor<ApplicationRepositoryService> constructor = ApplicationRepositoryService.class.getDeclaredConstructor();
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
    public void getDevCsvShowEventRepo() throws IOException {

        String environment = "dev";
        String fileStorage = "csv";

        ShowEventRepository showEventRepo;
        showEventRepo = ApplicationRepositoryService.getShowEventRepository(environment);

        assertEquals(1, showEventRepo.size());

    }

    @Test
    public void getPrdCsvShowEventRepo() throws IOException {

        String environment = "prd";
        String fileStorage = "csv";

        ShowEventRepository showEventRepo;
        showEventRepo = ApplicationRepositoryService.getShowEventRepository(environment);

        assertEquals(2, showEventRepo.size());

    }

    @Test
    public void getDevNotKnownFileStorageShowEventRepo() throws IOException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Not known filestorage property: bla");

        String environment = "dev";
        String fileStorage = "bla";

        ShowEventRepository showEventRepo;
        showEventRepo = ApplicationRepositoryService.getShowEventRepository(environment);

        assertEquals(2, showEventRepo.size());

    }
}
