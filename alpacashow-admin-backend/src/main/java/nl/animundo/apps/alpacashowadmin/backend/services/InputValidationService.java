package nl.animundo.apps.alpacashowadmin.backend.services;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public class InputValidationService {

    private InputValidationService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static void requiredFields(String requiredField, String field) {

        if ("".equals(requiredField.trim())) {

            throw new IllegalArgumentException("Veld " + field + " mag niet leeg zijn");

        }

    }


}
