package ru.appTesting.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.appTesting.spring.config.Config;
import ru.appTesting.spring.service.RunService;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);
        RunService runService = context.getBean(RunService.class);
        runService.runTest();
    }
}
