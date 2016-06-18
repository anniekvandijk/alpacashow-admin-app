package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

/**
 * Created by Anniek van Dijk on 15-6-2016.
 */
public class ConvertToCsvServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void excelXLSToCsvNotAllowed() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Upload excel file .xls not allowed");

        String file = "HALTERSHOW_haltershow.xls";
        ConvertToCsvService.convertToCsv(file);
    }

    @Test
    public void docxToCsvNotAllowed() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Upload filetype docx not allowed");

        String file = "HALTERSHOW_haltershow.docx";
        ConvertToCsvService.convertToCsv(file);
    }
    
    @Test
    public void excelXLSXToCsv() throws IOException {

        String file = "HALTERSHOW_haltershow.xlsx";
        ConvertToCsvService.convertToCsv(file);
    }

    @Test
    public void excelXLSXToCsvWithName() throws IOException {

        String file = "HALTERSHOW_haltershow2.xlsx";
        ConvertToCsvService.convertToCsv(file);
    }

}

