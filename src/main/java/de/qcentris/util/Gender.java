package de.qcentris.util;

public enum Gender {
    MALE("Male"), FEMALE("Female"), PREFER_NOT_TO_SAY("Prefer not say");

    private String genderName;

    Gender (String genderName) {
        this.genderName = genderName;
    }

    public String value () {
        return this.genderName;
    }
}
