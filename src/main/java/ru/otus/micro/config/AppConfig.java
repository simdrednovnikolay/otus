package ru.otus.micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.micro.dao.Question;
import ru.otus.micro.dao.QuestionImpl;
import ru.otus.micro.service.Testing;
import ru.otus.micro.service.TestingImpl;

@Configuration
public class AppConfig {

    @Bean
    Question createQuestion() {
        return new QuestionImpl();
    }

    @Bean
    Testing createTesting(Question q) {
        return new TestingImpl(q);
    }
}
