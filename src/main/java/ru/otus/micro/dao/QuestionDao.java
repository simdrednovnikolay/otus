package ru.otus.micro.dao;

import ru.otus.micro.domain.AnswerDto;
import ru.otus.micro.domain.QuestionDto;

import java.io.IOException;

public interface QuestionDao {

    QuestionDto getQuestion(int question) throws IOException;

    AnswerDto checkResult(int question, int answer) throws IOException;

    String analyseAnswer(AnswerDto answerDto, int numberOfQuestion);
}
