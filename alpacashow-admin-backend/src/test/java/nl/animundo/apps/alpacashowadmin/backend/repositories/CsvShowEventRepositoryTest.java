package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventSearch;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 18-7-2016.
 */
public class CsvShowEventRepositoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventFromFile() throws IOException {

        // TODO filelocagtion
        // add tests

        File file = new File("D:\\Java\\alpacashow-admin-app\\alpacashow-admin-backend\\src\\test\\resources\\csv\\SHOWEVENTS.csv");
        Reader reader = new FileReader(file) ;

        ShowEventRepository repo = CsvShowEventRepository.create(reader);


        ShowEventSearch searchOption = ShowEventSearch.NAME;
        String searchFor = "Meppel 2016";
        ShowEvent showEvent = repo.search(searchOption, searchFor);
    }
}
