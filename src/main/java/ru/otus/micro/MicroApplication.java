package ru.otus.micro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.micro.config.AppConfig;
import ru.otus.micro.service.TestingService;

import java.io.IOException;

public class MicroApplication {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        TestingService test = configApplicationContext.getBean(TestingService.class);
        test.start();

        configApplicationContext.close();
    }
}
