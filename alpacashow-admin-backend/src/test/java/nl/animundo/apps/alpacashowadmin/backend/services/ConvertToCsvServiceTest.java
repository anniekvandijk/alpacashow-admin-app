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

        ShowType showType = ShowType.FLEECESHOW;
        String excelFile = "fleeeceshow.xls";
        ConvertToCsvService.convertExcelToCsv(excelFile, showType);
    }

    @Test
    public void excelXLSXToCsv() throws IOException {

        ShowType showType = ShowType.HALTERSHOW;
        String excelFile = "haltershow.xlsx";
        ConvertToCsvService.convertExcelToCsv(excelFile, showType);
    }

    @Test
    public void excelXLSXToCsvWithName() throws IOException {

        ShowType showType = ShowType.HALTERSHOW;
        String excelFile = "haltershow2.xlsx";
        ConvertToCsvService.convertExcelToCsv(excelFile, showType);
    }

}

