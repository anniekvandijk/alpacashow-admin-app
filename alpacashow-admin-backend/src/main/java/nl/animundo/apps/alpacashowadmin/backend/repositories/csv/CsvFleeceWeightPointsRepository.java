package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventAnimal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventAnimalRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.AbstractCollection;

public class CsvFleeceWeightPointsRepository extends FleeceWeightPointsRepository {

    private static final int COL_BREED = 0;
    private static final int COL_AGECLASS= 1;
    private static final int COL_CLEANWEIGHT = 2;
    private static final int COL_WEIGHTPOINTS = 3;

    public static FleeceWeightPointsRepository importData(Reader reader) throws IOException {

        CsvFleeceWeightPointsRepository repo = new CsvFleeceWeightPointsRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final FleeceWeightPointsRepository fleeceWeightPointsRepository) throws IOException {
        writer  .append("BREED").append(";")
                .append("AGECLASS").append(";")
                .append("CLEANWEIGHT").append(";")
                .append("WEIGHTPOINTS").append("\n");

        for (String fleeceWeightPoints : fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet()) {
            FleeceWeightPoints points = fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(fleeceWeightPoints);
            writer  .append(points.getBreed().name()).append(";")
                    .append(points.getAgeClass().toString()).append(";")
                    .append(Float.toString(points.getCleanFleeceWeight())).append(";")
                    .append(Float.toString(points.getWeightPoints())).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            BreedClass breedCln = BreedClass.valueOf(StringUtils.trimToNull(nextLine[COL_BREED]));
            AgeClass ageClassCln = AgeClass.valueOf(StringUtils.trimToNull(nextLine[COL_AGECLASS]));
            float cleanWeight = Float.parseFloat(StringUtils.trimToNull(nextLine[COL_CLEANWEIGHT]));
            float weightPoints = Float.parseFloat(StringUtils.trimToNull(nextLine[COL_WEIGHTPOINTS]));

            add(new FleeceWeightPoints(breedCln, ageClassCln, cleanWeight, weightPoints));
        }
        csvReader.close();
    }
}
