package ru.otus.micro.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Question {

    void getQuestion(int question) throws IOException;

    void checkResult(int question, int answer) throws IOException;
}
