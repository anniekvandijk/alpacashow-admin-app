package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.UUID;

public class CsvShowEventParticipantAnimalRepository extends Repository<ShowEventParticipantAnimal> {

    private static final int COL_ID = 0;
    private static final int COL_SHOWEVENTID = 1;
    private static final int COL_PARTICIPANTID= 2;
    private static final int COL_ANIMALID= 3;

    public static Repository<ShowEventParticipantAnimal> importData(Reader reader) throws IOException {

        CsvShowEventParticipantAnimalRepository repo = new CsvShowEventParticipantAnimalRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final Repository<ShowEventParticipantAnimal> showEventParticipantAnimalRepo) throws IOException {
        writer  .append("ID").append(";")
                .append("SHOWEVENTID").append(";")
                .append("PARTICIPANTID").append(";")
                .append("ANIMALID").append("\n");

        for (String id : showEventParticipantAnimalRepo.getAllById()) {
            ShowEventParticipantAnimal spa = showEventParticipantAnimalRepo.getById(id);
            writer  .append(spa.getId()).append(";")
                    .append(spa.getShowEventId()).append(";")
                    .append(spa.getParticipantId()).append(";");
                    if (spa.getAnimalId() != null) {
                        writer.append(spa.getAnimalId()).append("\n");
                    }
                    else {
                        writer.append("\n");
                    }
            }
        }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String idCln = StringUtils.trimToNull(nextLine[COL_ID]);
            String showEventIdCln = StringUtils.trimToNull(nextLine[COL_SHOWEVENTID]);
            String participantIdCln = StringUtils.trimToNull(nextLine[COL_PARTICIPANTID]);
            String animalIdCln = StringUtils.trimToNull(nextLine[COL_ANIMALID]);

            add(idCln, new ShowEventParticipantAnimal(idCln, showEventIdCln, participantIdCln, animalIdCln));
        }
        csvReader.close();
    }
}
