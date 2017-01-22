package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventAnimalDetailRepository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvShowEventAnimalDetailRepository extends ShowEventAnimalDetailRepository {

    private static final int COL_SHOWEVENTKEY = 0;
    private static final int COL_PARTICIPANTKEY= 1;
    private static final int COL_ANIMALKEY = 2;
    private static final int COL_SHEERDATE = 3;
    private static final int COL_BEFORESHEERDATE = 4;
    private static final int COL_AGECLASS = 5;
    private static final int COL_SHOWCLASS = 6;


    public static ShowEventAnimalDetailRepository importData(Reader reader) throws IOException {

        CsvShowEventAnimalDetailRepository repo = new CsvShowEventAnimalDetailRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventAnimalDetailRepository showEventAnimalDetailRepository) throws IOException {
        writer  .append("SHOWEVENTKEY").append(";")
                .append("PARTICIPANTKEY").append(";")
                .append("ANIMALKEY").append(";")
                .append("SHEERDATE").append(";")
                .append("BEFORESHEERDATE").append(";")
                .append("AGECLASS").append(";")
                .append("SHOWCLASS").append("\n");

        for (String showEventAnimalDetail : showEventAnimalDetailRepository.getAllShowEventAnimalDetailsByKeySet()) {
            ShowEventAnimalDetail animalDetail = showEventAnimalDetailRepository.getShowEventAnimalDetailByKeySet(showEventAnimalDetail);
            writer  .append(animalDetail.getShowEventKey()).append(";")
                    .append(animalDetail.getParticipantKey()).append(";")
                    .append(animalDetail.getAnimalKey()).append(";");
                    if (animalDetail.getSheerDate() != null) {
                        writer.append(animalDetail.getSheerDate().toString());
                    }
                    writer.append(";");
                    if (animalDetail.getBeforeSheerDate() != null) {
                        writer.append(animalDetail.getBeforeSheerDate().toString());
                    }
                    writer.append(";");
                    if (animalDetail.getAgeClass() != null) {
                        writer.append(animalDetail.getAgeClass().name());
                    }
                    writer.append(";");
                    if (animalDetail.getShowClass() != 0) {
                        writer.append(String.valueOf(animalDetail.getShowClass()));
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
            AgeClass ageClass = AgeClass.valueOf(StringUtils.trimToNull(nextLine[COL_AGECLASS]));
            int showClass = Integer.valueOf(StringUtils.trimToNull(nextLine[COL_SHOWCLASS]));
            add(new ShowEventAnimalDetail(showEventKeyCln, participantKeyCln, animalKeyCln, formattedSheerDate, formattedBeforeSheerDate, ageClass, showClass));
        }
        csvReader.close();
    }
}
