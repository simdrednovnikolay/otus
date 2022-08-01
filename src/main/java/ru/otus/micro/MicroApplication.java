package ru.otus.micro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.micro.config.AppConfig;
import ru.otus.micro.service.Testing;

import java.io.IOException;
import java.util.Scanner;

public class MicroApplication {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Testing test = configApplicationContext.getBean(Testing.class);

        System.out.println("Hello this is a testing program.\nChoose the correct answer:\n");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            test.getTesting(i);

            System.out.println("\n");

            int answer = scanner.nextInt();

            test.getResult(i, answer);
        }

        configApplicationContext.close();
    }
}
