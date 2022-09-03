package ru.otus.micro.service;

import lombok.RequiredArgsConstructor;
import ru.otus.micro.dao.QuestionDao;
import ru.otus.micro.domain.AnswerDto;
import ru.otus.micro.domain.QuestionDto;

import java.io.IOException;
import java.util.Scanner;

@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {
    private final QuestionDao questionDao;

    @Override
    public void print(Object topic) {
        System.out.println(topic);
    }

    @Override
    public void start() throws IOException {
        System.out.println("Hello this is a testing program.\nChoose the correct answer:\n");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            QuestionDto questionForPrint = questionDao.getQuestion(i);
            print(questionForPrint);

            System.out.println("\n");

            int answer = scanner.nextInt();

            AnswerDto answerDto = questionDao.checkResult(i, answer);
            String resultForPrint = questionDao.analyseAnswer(answerDto, answer);
            print(resultForPrint);
        }
    }
}