package ru.otus.boot.dao;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.boot.config.CsvConfig;
import ru.otus.boot.domain.AnswerDto;
import ru.otus.boot.domain.QuestionDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuestionDaoImplTest {
    @Autowired
    private CsvConfig csvConfig;
    @Autowired
    private QuestionDao questionDao;

    @Test
    @SneakyThrows
    void getQuestion() {
        QuestionDto expectedQuestion = QuestionDto.builder()
                .question("1")
                .build();

        QuestionDto actualQuestion = questionDao.getQuestion(0);

        assertThat(actualQuestion).isNotNull();
        assertThat(actualQuestion.getQuestion()).isEqualTo(expectedQuestion.getQuestion());
    }

    @Test
    @SneakyThrows
    void checkResult() {
        AnswerDto expectedAnswer = AnswerDto.builder()
                .answer(2)
                .build();

        AnswerDto actualAnswer = questionDao.checkResult(0, 1);

        assertThat(actualAnswer).isNotNull();
        assertThat(actualAnswer.getAnswer()).isEqualTo(expectedAnswer.getAnswer());
    }

    @Test
    void analyseAnswer() {
        AnswerDto expectedAnswer = AnswerDto.builder()
                .answer(1)
                .build();
        String expectedAnalyse = "message.correct";

        String actualAnalyse = questionDao.analyseAnswer(expectedAnswer, 1);

        assertThat(actualAnalyse).isNotNull().isEqualTo(expectedAnalyse);
    }
}