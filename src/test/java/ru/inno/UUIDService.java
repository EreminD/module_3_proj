package ru.inno;

import java.util.UUID;

public class UUIDService {

    private final UUID id;


    public UUIDService(StringService stringService) {
        System.out.println("я создался " + stringService.getUuid());
        this.id = UUID.fromString(stringService.getUuid());
    }

    public UUID getId() {
        return id;
    }
}
