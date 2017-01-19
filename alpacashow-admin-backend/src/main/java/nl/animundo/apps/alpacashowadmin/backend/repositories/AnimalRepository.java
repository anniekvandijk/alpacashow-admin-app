package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.utilities.AnimalComparator;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class AnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(AnimalRepository.class);
    private Map<String, Animal> animals = new HashMap<>();


    public String add(final Animal animal) {

        String animalKey = animal.getMicrochip();
        if (getAnimalByKeySet(animalKey) != null) {
            animals.remove(animalKey);
            animals.put(animalKey, animal);
            logger.info("Updated animal '" + animalKey + "' to animalRepo");
        } else {
            animals.put(animalKey, animal);
            logger.info("Added animal '" + animalKey + "' to animalRepo");
        }
        return animalKey;
    }

    public String delete(final String animalKey) {

        Animal animalToDelete = getAnimalByKeySet(animalKey);
        if (animalToDelete != null) {
            animals.remove(animalKey);
            logger.info("Deleted animal '" + animalKey + "' from animalRepo");
            return animalToDelete.getMicrochip();
        } else {
            return null;
        }
    }

    public Set<String> getAllAnimalsByKeySet() {
        return animals.keySet();
    }

    public SortedSet<Animal> getAllAnimals() {
        SortedSet<Animal> animalSet = new TreeSet<>(new AnimalComparator());
        for (Animal animal : animals.values()) {
            animalSet.add(animal);
        }
        return animalSet;
    }

    public Animal getAnimalByKeySet(final String keySet) {
        return animals.get(keySet);
    }

}
