package ru.otus.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.boot.dao.QuestionDao;
import ru.otus.boot.domain.AnswerDto;
import ru.otus.boot.domain.QuestionDto;

import java.io.IOException;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {
    private final QuestionDao questionDao;
    private final LocalisationService localisationService;

    @Override
    public void print(String message) {
        System.out.println(localisationService.getLocaleMessage(message, null));
    }

    @Override
    public void start() throws IOException {
        print("message.hello");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            QuestionDto questionForPrint = questionDao.getQuestion(i);
            print(questionForPrint.toString());

            int answer = scanner.nextInt();

            AnswerDto answerDto = questionDao.checkResult(i, answer);
            String resultForPrint = questionDao.analyseAnswer(answerDto, answer);
            print(resultForPrint);
        }
    }
}