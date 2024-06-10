package ru.inno.utils;

public class StringUtils {
    public boolean isEmail(String text) {
        String[] parts = text.split("@");
        return !parts[0].isEmpty()
                && !parts[0].isBlank()
                && text.contains("@")
                && parts[1].contains(".")
                && parts.length == 2
                && !text.contains(" ");
    }
}
