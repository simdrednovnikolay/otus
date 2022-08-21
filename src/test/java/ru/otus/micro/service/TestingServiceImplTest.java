package ru.otus.micro.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.micro.dao.QuestionDao;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class TestingServiceImplTest {
    @Mock
    private QuestionDao questionDao;
    private TestingServiceImpl testing;

    @BeforeEach
    void setUp() {
        testing = new TestingServiceImpl(questionDao);
    }

    @Test
    @SneakyThrows
    void shouldFrownExceptionWhenGetTesting() {
        doThrow(new IOException()).when(questionDao).getQuestion(anyInt());

        Exception exception = assertThrows(IOException.class, () -> testing.start());

        assertThat(exception).isInstanceOf(IOException.class);
    }
}