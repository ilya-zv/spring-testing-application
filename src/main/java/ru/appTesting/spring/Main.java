package ru.appTesting.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.appTesting.spring.config.Config;
import ru.appTesting.spring.service.RunService;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);
        RunService runService = context.getBean(RunService.class);
        runService.runTest();
    }
}
