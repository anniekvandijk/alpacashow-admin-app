package nl.animundo.apps.alpacashowadmin.main;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anniek van Dijk on 29-5-2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Alpaca show application is running !");

        LocalDate now = LocalDate.now();
        System.out.println(now);
    }
}
