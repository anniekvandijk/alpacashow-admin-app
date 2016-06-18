package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Anniek van Dijk on 15-6-2016.
 */
public class ConvertFileToCsvServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void excelXLSToCsvNotAllowed() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Upload excel file .xls not allowed");

        String file = "HALTERSHOW_haltershow.xls";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void docxToCsvNotAllowed() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Upload filetype docx not allowed");

        String file = "HALTERSHOW_haltershow.docx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void fileNotFound() throws IOException {

        exception.expect(FileNotFoundException.class);
        exception.expectMessage("File does not excist in upload directory");

        String file = "HALTERSHOW_waltershow.xlsx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void excelXLSXToCsv() throws IOException {

        String file = "HALTERSHOW_haltershow.xlsx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void excelXLSXToCsvWithName() throws IOException {

        String file = "HALTERSHOW_haltershow2.xlsx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

}

