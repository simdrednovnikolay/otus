package ru.otus.micro.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.micro.dao.Question;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Сервис тестирования")
class TestingImplTest {
    @Mock
    private Question question;
    @InjectMocks
    private TestingImpl testing;

    @Test
    @SneakyThrows
    @DisplayName("Должен выбросить исключение при вывозе метода getTesting")
    void shouldFrownExceptionWhenGetTesting() {
        doThrow(new IOException()).when(question).getQuestion(anyInt());

        Exception exception = assertThrows(IOException.class, () -> testing.getTesting(anyInt()));

        assertThat(exception).isInstanceOf(IOException.class);
    }

    @Test
    @SneakyThrows
    @DisplayName("должен вызвать метод getTesting")
    void shouldCallGetTestingMethod() {

        testing.getTesting(anyInt());

        verify(question).getQuestion(anyInt());
    }

    @Test
    @SneakyThrows
    @DisplayName("должен вызвать метод checkResult")
    void shouldCallCheckResultMethod() {
        testing.getResult(anyInt(), anyInt());

        verify(question).checkResult(anyInt(), anyInt());
    }
}