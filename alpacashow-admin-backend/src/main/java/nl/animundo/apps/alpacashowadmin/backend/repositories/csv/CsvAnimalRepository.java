package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvAnimalRepository extends Repository<Animal> {

    private static final int COL_ID = 0;
    private static final int COL_NAME = 1;
    private static final int COL_BREED = 2;
    private static final int COL_SEX = 3;
    private static final int COL_COLOR = 4;
    private static final int COL_DATEOFBIRTH = 5;
    private static final int COL_MICROCHIP = 6;
    private static final int COL_REGISTRATION = 7;
    private static final int COL_SIRE = 8;
    private static final int COL_DAM = 9;

    public static Repository<Animal> importData(Reader reader) throws IOException {

        CsvAnimalRepository repo = new CsvAnimalRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final Repository<Animal> animalRepo) throws IOException {
        writer  .append("ID").append(";")
                .append("NAME").append(";")
                .append("BREED").append(";")
                .append("SEX").append(";")
                .append("COLOR").append(";")
                .append("DATEOFBIRTH").append(";")
                .append("MICROCHIP").append(";")
                .append("REGISTRATION").append(";")
                .append("SIRE").append(";")
                .append("DAM").append("\n");

        for (String id : animalRepo.getAllById()) {
            Animal ani = animalRepo.getById(id);
            writer  .append(ani.getId()).append(";")
                    .append(ani.getName()).append(";")
                    .append(ani.getBreed().toString()).append(";")
                    .append(ani.getSex().toString()).append(";")
                    .append(ani.getColor().toString()).append(";")
                    .append(ani.getDateOfBirth().toString()).append(";")
                    .append(ani.getMicrochip()).append(";");
                    if (ani.getRegistration() != null) {
                        writer.append(ani.getRegistration());
                    }
                    writer.append(";")
                    .append(ani.getSire()).append(";")
                    .append(ani.getDam()).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String idCln = StringUtils.trimToNull(nextLine[COL_ID]);
            String nameCln = StringUtils.trimToNull(nextLine[COL_NAME]);
            BreedClass breedCln = BreedClass.valueOf(StringUtils.trimToNull(nextLine[COL_BREED]));
            SexClass sexCln = SexClass.valueOf(StringUtils.trimToNull(nextLine[COL_SEX]));
            ColorClass colorCln = ColorClass.valueOf(StringUtils.trimToNull(nextLine[COL_COLOR]));
            String dateOfBirthCln = StringUtils.trimToNull(nextLine[COL_DATEOFBIRTH]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthCln, formatter);
            String microchipCln = StringUtils.trimToNull(nextLine[COL_MICROCHIP]);
            String registrationCln = StringUtils.trimToNull(nextLine[COL_REGISTRATION]);
            String sireCln = StringUtils.trimToNull(nextLine[COL_SIRE]);
            String damCln = StringUtils.trimToNull(nextLine[COL_DAM]);

            add(idCln, new Animal(idCln, nameCln, breedCln, sexCln, colorCln, dateOfBirth, microchipCln, registrationCln, sireCln, damCln));
        }
        csvReader.close();
    }
}
