package nl.animundo.apps.alpacashowadmin.backend.Utilities;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getName().compareTo(animal2.getName());
    }
}
