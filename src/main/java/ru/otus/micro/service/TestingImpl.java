package ru.otus.micro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.micro.dao.Question;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TestingImpl implements Testing {
    private final Question question;

    @Override
    public void getTesting(int question) throws IOException {
        this.question.getQuestion(question);
    }

    @Override
    public void getResult(int question, int answer) throws IOException {
        this.question.checkResult(question,answer);
    }
}