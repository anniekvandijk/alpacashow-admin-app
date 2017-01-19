package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventAnimal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventAnimalRepository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvShowEventAnimalRepository extends ShowEventAnimalRepository {

    private static final int COL_SHOWEVENTKEY = 0;
    private static final int COL_PARTICIPANTKEY= 1;
    private static final int COL_ANIMALKEY = 2;
    private static final int COL_SHEERDATE = 3;
    private static final int COL_BEFORESHEERDATE = 4;

    public static ShowEventAnimalRepository importData(Reader reader) throws IOException {

        CsvShowEventAnimalRepository repo = new CsvShowEventAnimalRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventAnimalRepository showEventAnimalRepository) throws IOException {
        writer  .append("SHOWEVENTKEY").append(";")
                .append("PARTICIPANTKEY").append(";")
                .append("ANIMALKEY").append(";")
                .append("SHEERDATE").append(";")
                .append("BEFORESHEERDATE").append("\n");

        for (String showEventAnimal : showEventAnimalRepository.getAllShowEventAnimalsByKeySet()) {
            ShowEventAnimal animal = showEventAnimalRepository.getShowEventAnimalByKeySet(showEventAnimal);
            writer  .append(animal.getShowEventKey()).append(";")
                    .append(animal.getParticipantKey()).append(";")
                    .append(animal.getAnimalKey()).append(";");
                    if (animal.getSheerDate() != null) {
                        writer.append(animal.getSheerDate().toString());
                    }
                    writer.append(";");
                    if (animal.getBeforeSheerDate() != null) {
                        writer.append(animal.getBeforeSheerDate().toString());
                    }
                    writer.append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String showEventKeyCln = StringUtils.trimToNull(nextLine[COL_SHOWEVENTKEY]);
            String participantKeyCln = StringUtils.trimToNull(nextLine[COL_PARTICIPANTKEY]);
            String animalKeyCln = StringUtils.trimToNull(nextLine[COL_ANIMALKEY]);
            String sheerDateCln = StringUtils.trimToNull(nextLine[COL_SHEERDATE]);
            String beforeSheerDateCln = StringUtils.trimToNull(nextLine[COL_BEFORESHEERDATE]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate formattedSheerDate = null;
            if (sheerDateCln != null) {
                formattedSheerDate = LocalDate.parse(sheerDateCln, formatter);
            }
            LocalDate formattedBeforeSheerDate = null;
            if (beforeSheerDateCln != null) {
                formattedBeforeSheerDate = LocalDate.parse(beforeSheerDateCln, formatter);
            }

            add(new ShowEventAnimal(showEventKeyCln, participantKeyCln, animalKeyCln, formattedSheerDate, formattedBeforeSheerDate));
        }
        csvReader.close();
    }
}
