package ru.appTesting.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.appTesting.spring.service.RunService;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class);
        RunService runService = context.getBean(RunService.class);
        runService.runTest();
    }
}
