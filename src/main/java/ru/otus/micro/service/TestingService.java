package ru.otus.micro.service;

import java.io.IOException;

public interface TestingService {

    void print(Object topic);

    void start() throws IOException;
}
