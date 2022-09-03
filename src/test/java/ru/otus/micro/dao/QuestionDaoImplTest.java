package ru.otus.micro.dao;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.micro.domain.AnswerDto;
import ru.otus.micro.domain.QuestionDto;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class QuestionDaoImplTest {
    @Mock
    private QuestionDao questionDao;

    @BeforeEach
    void setUp() {
        questionDao = new QuestionDaoImpl();
    }

    @Test
    @SneakyThrows
    void getQuestion() {
        QuestionDto expectedQuestion = QuestionDto.builder()
                .question("[1 What did the elephant do when he came to the field?,  1 Ran away,  2 Chewed grass]")
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
        String expectedAnalyse = "Great\n";

        String actualAnalyse = questionDao.analyseAnswer(expectedAnswer, 1);

        assertThat(actualAnalyse).isNotNull().isEqualTo(expectedAnalyse);
    }
}