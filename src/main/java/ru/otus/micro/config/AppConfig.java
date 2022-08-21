package ru.otus.micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.micro.dao.QuestionDao;
import ru.otus.micro.dao.QuestionDaoImpl;
import ru.otus.micro.service.TestingService;
import ru.otus.micro.service.TestingServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    QuestionDao createQuestion() {
        return new QuestionDaoImpl();
    }

    @Bean
    TestingService createTesting(QuestionDao q) {
        return new TestingServiceImpl(q);
    }
}
