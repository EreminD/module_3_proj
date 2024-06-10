package ru.inno;

import java.util.UUID;

public class StringService {
    private final String uuid;

    public StringService() {
        this.uuid = UUID.randomUUID().toString();
    }



    public String getUuid() {
        return uuid;
    }
}
