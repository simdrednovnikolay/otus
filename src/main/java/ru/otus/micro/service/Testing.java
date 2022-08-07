package ru.otus.micro.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Testing {

    void getTesting(int question) throws IOException;

    void getResult(int answer, int question) throws IOException;
}
