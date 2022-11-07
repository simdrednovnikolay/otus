package ru.otus.boot.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.boot.dao.QuestionDao;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class TestingServiceImplTest {
    @Mock
    private QuestionDao questionDao;
    @Mock
    private LocalisationService localisationService;
    private TestingServiceImpl testing;

    @BeforeEach
    void setUp() {
        testing = new TestingServiceImpl(questionDao, localisationService);
    }

    @Test
    @SneakyThrows
    void shouldFrownExceptionWhenGetTesting() {
        doThrow(new IOException()).when(questionDao).getQuestion(anyInt());

        Exception exception = assertThrows(IOException.class, () -> testing.start());

        assertThat(exception).isInstanceOf(IOException.class);
    }
}