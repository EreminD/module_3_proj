package ru.inno.cucumber;

import io.cucumber.java.After;

public class Hooks {
    private DriverService service;

    public Hooks(DriverService service) {
        this.service = service;
    }

    @After
    public void tearDown() {
        System.out.println("тушим драйвер");
        service.quitDriver();
    }
}
