package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public enum SexClass {

    FEMALE ("Female"),
    MALE ("Male");


    private final String sex;

    SexClass(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
