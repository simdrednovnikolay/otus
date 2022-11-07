package ru.otus.boot.service;

import java.io.IOException;

public interface TestingService {

    void print(String topic);

    void start() throws IOException;
}
