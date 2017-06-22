package com.projects.cactus.weatherapp.util;

public class StringUtils {
    public static String capitalizeString(String description) {

        StringBuilder descriptionSb = new StringBuilder(description);
        descriptionSb.setCharAt(0, Character.toUpperCase(descriptionSb.charAt(0)));
        description = descriptionSb.toString();
        return description;
    }
}