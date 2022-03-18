package de.qcentris.util;

public enum EducationLevel {
    College("College"),High_School("high school"),Grad_School("grad school");

    private String level;

    EducationLevel(String level) {
        this.level = level;
    }

    public String level() {
        return this.level;
    }
}
