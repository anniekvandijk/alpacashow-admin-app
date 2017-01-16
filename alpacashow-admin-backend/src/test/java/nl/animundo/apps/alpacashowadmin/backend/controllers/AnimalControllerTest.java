package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class AnimalControllerTest {

    private AnimalRepository animalRepository;
    private ApplicationRepositoryService service = new ApplicationRepositoryService();

    @Test
    public void getAllAnimals() throws IOException {

        AnimalController controller = new AnimalController(animalRepository);

        String result = (String)controller.getAnimals().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allanimals.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getAnimalByKey() throws IOException {

        AnimalController controller = new AnimalController(animalRepository);

        Response resultCode = controller.getAnimalByKey("12346");
        String result = (String) controller.getAnimalByKey("12346").getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_animalbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
        assertEquals(200, resultCode.getStatus());
    }

    @Test
    public void addDeleteUpdateAnimal() throws IOException {

        loadRepository();
        assertEquals(3, animalRepository.getAllAnimals().size());

        AnimalController controller = new AnimalController(animalRepository);

        String file = readJsonfile("add_animal.json");
        controller.addAnimal(file);

        loadRepository();
        assertEquals(4, animalRepository.getAllAnimals().size());

        Animal animal = animalRepository.getAnimalByKeySet("chippie");
        assertEquals("SURI", animal.getBreed().toString());

        String file2 = readJsonfile("update_animal.json");
        controller.updateAnimal("chippie", file2);

        loadRepository();
        Animal animal2 = animalRepository.getAnimalByKeySet("chippie");
        assertEquals("HUACAYA", animal2.getBreed().toString());

        controller.deleteAnimal("chippie");

    }

    @Test
    public void getAnimalByNotExistingKey() throws IOException {

        AnimalController controller = new AnimalController(animalRepository);

        Response resultCode = controller.getAnimalByKey("Some not known animal");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addAnimalWithWrongData() throws IOException {

        loadRepository();

        AnimalController controller = new AnimalController(animalRepository);

        String file = readJsonfile("add_animalWrong.json");
        Response resultCode = controller.addAnimal(file);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateAnimalWithWrongKey() throws IOException {

        loadRepository();
        AnimalController controller = new AnimalController(animalRepository);

        String file = readJsonfile("update_animal.json");
        Response resultCode = controller.updateAnimal("not known chip", file);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateAnimalWithWrongData() throws IOException {

        loadRepository();
        AnimalController controller = new AnimalController(animalRepository);

        String file = readJsonfile("update_animalWrong.json");
        Response resultCode = controller.updateAnimal("12347", file);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteAnimalWithWrongKey() throws IOException {

        loadRepository();

        AnimalController controller = new AnimalController(animalRepository);
        Response resultCode = controller.deleteAnimal("Animal X");

        assertEquals(404, resultCode.getStatus());

    }

    private void loadRepository() throws IOException {

        animalRepository = service.loadAnimalRepository();
    }
}
