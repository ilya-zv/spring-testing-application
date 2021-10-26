package ru.appTesting.spring.config;

import org.springframework.context.annotation.*;
import ru.appTesting.spring.dao.QuestionDao;
import ru.appTesting.spring.dao.QuestionDaoImpl;
import ru.appTesting.spring.service.*;

@Configuration
@PropertySource("classpath:file.properties")
public class Config {

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoImpl();
    }

    @Bean
    public QuestionService questionService() {
        return new QuestionServiceImpl(questionDao());
    }

    @Bean
    public IOService ioService() {
        return new IOServiceImpl();
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

    @Bean
    public RunService runService() {
        return new RunServiceImpl(ioService(), personService(), testService());
    }

    @Bean
    public TestService testService() {
        return new TestServiceImpl(questionDao(), ioService());
    }
}
