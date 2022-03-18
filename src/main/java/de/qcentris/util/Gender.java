package de.qcentris.util;

public enum Gender {
    MALE("College"),FEMALE("high school"),PREFER_NOT_TO_SAY("grad school");

    private String genderName;

    Gender(String genderName) {
        this.genderName = genderName;
    }

    public String value() {
        return this.genderName;
    }
}
