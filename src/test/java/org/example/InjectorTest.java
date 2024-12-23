package org.example;

//package com.labs.reflection.injector;

import reflection.SomeInterface;
import reflection.SomeOtherInterface;
import reflection.SomeImpl;
import reflection.SODoer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class InjectorTest {

    private Injector<SomeBean> injector;

    @BeforeEach
    public void setUp() throws Exception {
        // Создаем временный файл с конфигурацией
        String configContent = "org.example.SomeInterface=org.example.SomeImpl\n" +
                "org.example.SomeOtherInterface=org.example.SODoer";
        Path tempFile = Files.createTempFile("config", ".properties");
        Files.write(tempFile, configContent.getBytes(StandardCharsets.UTF_8));

        // Инициализируем Injector с временным файлом
        injector = new Injector<>(tempFile.toString());
    }




    private static class TestBean {
        @AutoInjectable
        private SomeInterface someInterface;
        @AutoInjectable
        private SomeOtherInterface someOtherInterface;
    }
}
