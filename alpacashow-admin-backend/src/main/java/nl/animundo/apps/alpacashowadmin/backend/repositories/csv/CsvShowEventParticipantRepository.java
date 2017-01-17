package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventParticipant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvShowEventParticipantRepository extends ShowEventParticipantRepository {

    private static final int COL_SHOWEVENTKEY = 0;
    private static final int COL_PARTICIPANTKEY= 1;

    public static ShowEventParticipantRepository importData(Reader reader) throws IOException {

        CsvShowEventParticipantRepository repo = new CsvShowEventParticipantRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventParticipantRepository showEventParticipantRepository) throws IOException {
        writer  .append("SHOWEVENTKEY").append(";")
                .append("PARTICIPANTKEY").append("\n");

        for (String showEventParticipant : showEventParticipantRepository.getAllShowEventParticipantsByKeySet()) {
            ShowEventParticipant participant = showEventParticipantRepository.getShowEventParticipantByKeySet(showEventParticipant);
            writer  .append(participant.getShowEventKey()).append(";")
                    .append(participant.getParticipantKey()).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String showEventKeyCln = StringUtils.trimToNull(nextLine[COL_SHOWEVENTKEY]);
            String participantKeyCln = StringUtils.trimToNull(nextLine[COL_PARTICIPANTKEY]);

            add(new ShowEventParticipant(showEventKeyCln, participantKeyCln));
        }
        csvReader.close();
    }
}
