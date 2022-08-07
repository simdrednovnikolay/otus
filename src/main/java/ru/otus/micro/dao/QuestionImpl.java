package ru.otus.micro.dao;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QuestionImpl implements Question {
    @Override
    public void getQuestion(int question) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/Questions.csv"), ';', '"', question);
        String[] readQuestion = reader.readNext();
        System.out.println(Objects.requireNonNull(Arrays.toString(readQuestion).replace("[","")
                .replace("]","")));
    }

    @Override
    public void checkResult(int question, int answer) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/Answers.csv"), ';', '"', question);

        List<String[]> readAnswer = reader.readAll();
        int correctAnswer = readAnswer.stream()
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .findFirst()
                .orElse(0);

        System.out.println(correctAnswer == answer ? "Great\n" : "Incorrect answer\n");
    }
}