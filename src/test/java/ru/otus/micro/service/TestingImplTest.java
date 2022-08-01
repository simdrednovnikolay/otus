package ru.otus.micro.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.micro.dao.Question;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class TestingImplTest {
    @Mock
    private Question question;
    private TestingImpl testing;

    @BeforeEach
    void setUp() {
        testing = new TestingImpl(question);
    }

    @Test
    @SneakyThrows
    void shouldFrownExceptionWhenGetTesting() {
        doThrow(new IOException()).when(question).getQuestion(anyInt());

        Exception exception = assertThrows(IOException.class, () -> testing.getTesting(anyInt()));

        assertThat(exception).isInstanceOf(IOException.class);
    }
}