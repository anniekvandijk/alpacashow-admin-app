package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvShowEventRegistrationRepository extends ShowEventRegistrationRepository {

    private static final int COL_SHOWEVENTKEY = 0;
    private static final int COL_PARTICIPANTKEY= 1;
    private static final int COL_ANIMALKEY = 2;
    private static final int COL_AGECLASS = 3;
    private static final int COL_SHOWCLASSCODE = 4;
    private static final int COL_SHEERDATE = 5;
    private static final int COL_BEFORESHEERDATE = 6;

    public static ShowEventRegistrationRepository importData(Reader reader) throws IOException {

        CsvShowEventRegistrationRepository repo = new CsvShowEventRegistrationRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventRegistrationRepository showEventRegistrationRepository) throws IOException {
        writer  .append("SHOWEVENTKEY").append(";")
                .append("PARTICIPANTKEY").append(";")
                .append("ANIMALKEY").append(";")
                .append("AGECLASS").append(";")
                .append("SHOWCLASSCODE").append(";")
                .append("SHEERDATE").append(";")
                .append("BEFORESHEERDATE").append("\n");

        for (String showEventRegistration : showEventRegistrationRepository.getAllShowEventRegistrationsByKeySet()) {
            ShowEventRegistration registration = showEventRegistrationRepository.getShowEventRegistrationByKeySet(showEventRegistration);
            writer  .append(registration.getShowEventKey()).append(";")
                    .append(registration.getParticipantKey()).append(";")
                    .append(registration.getAnimalKey()).append(";")
                    .append(registration.getAgeClass().name()).append(";")
                    .append(String.valueOf(registration.getShowClassCode())).append(";");
                    if (registration.getSheerDate() != null) {
                        writer.append(registration.getSheerDate().toString());
                    }
                    writer.append(";");
                    if (registration.getBeforeSheerDate() != null) {
                        writer.append(registration.getBeforeSheerDate().toString());
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
            AgeClass ageClassCln = AgeClass.valueOf(StringUtils.trimToNull(nextLine[COL_AGECLASS]));
            int showClassCodeCln = Integer.parseInt(StringUtils.trimToNull(nextLine[COL_SHOWCLASSCODE]));
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

            add(new ShowEventRegistration(showEventKeyCln, participantKeyCln, animalKeyCln, ageClassCln, showClassCodeCln, formattedSheerDate, formattedBeforeSheerDate));
        }
        csvReader.close();
    }
}
