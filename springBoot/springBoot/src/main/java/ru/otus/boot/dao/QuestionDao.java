package ru.otus.boot.dao;

import ru.otus.boot.domain.AnswerDto;
import ru.otus.boot.domain.QuestionDto;

import java.io.IOException;

public interface QuestionDao {

    QuestionDto getQuestion(int question) throws IOException;

    AnswerDto checkResult(int question, int answer) throws IOException;

    String analyseAnswer(AnswerDto answerDto, int numberOfQuestion);
}
