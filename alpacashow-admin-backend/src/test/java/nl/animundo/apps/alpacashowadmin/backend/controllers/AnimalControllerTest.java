package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class AnimalControllerTest {

    private RepositoryContext context;
    private AnimalController controller;
    private ApplicationRepositoryService service;

    @Before
    public void before() throws IOException {
        context = new RepositoryContext();
        service = new ApplicationRepositoryService();
        context.animalRepository = service.loadAnimalRepository();
        controller = new AnimalController(context);
    }

    @Test
    public void getAllAnimals() throws IOException {

        String result = (String)controller.getAnimals().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allanimals.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getAnimalByKey() throws IOException {

        Response resultCode = controller.getAnimalByKey("4444");
        String result = (String) controller.getAnimalByKey("4444").getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_animalbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
        assertEquals(200, resultCode.getStatus());
    }

    @Test
    public void addDeleteUpdateAnimal() throws IOException {

        assertEquals(5, context.animalRepository.getAllAnimals().size());

        String file = readJsonfile("add_animal.json");
        controller.addAnimal(file);

        assertEquals(6, context.animalRepository.getAllAnimals().size());

        Animal animal = context.animalRepository.getAnimalById("chippie");
        assertEquals("SURI", animal.getBreed().toString());

        String file2 = readJsonfile("update_animal.json");
        controller.updateAnimal("chippie", file2);

        Animal animal2 = context.animalRepository.getAnimalById("chippie");
        assertEquals("HUACAYA", animal2.getBreed().toString());

        controller.deleteAnimal("chippie");

    }

    @Test
    public void getAnimalByNotExistingKey() throws IOException {

        Response resultCode = controller.getAnimalByKey("Some not known animal");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addAnimalWithWrongData() throws IOException {

        String file = readJsonfile("add_animalWrong.json");
        Response resultCode = controller.addAnimal(file);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateAnimalWithWrongKey() throws IOException {

        String file = readJsonfile("update_animal.json");
        Response resultCode = controller.updateAnimal("not known chip", file);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateAnimalWithWrongData() throws IOException {

        String file = readJsonfile("update_animalWrong.json");
        Response resultCode = controller.updateAnimal("5555", file);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteAnimalWithWrongKey() throws IOException {

        Response resultCode = controller.deleteAnimal("Animal X");

        assertEquals(404, resultCode.getStatus());

    }
}
