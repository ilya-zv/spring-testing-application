package ru.appTesting.spring.service;

import ru.appTesting.spring.domain.Person;

public class RunServiceImpl implements RunService {
    IOService ioService;
    PersonService personService;
    TestService testService;


    public RunServiceImpl(IOService ioService, PersonService personService, TestService testService) {
        this.ioService = ioService;
        this.personService = personService;
        this.testService = testService;
    }

    @Override
    public void runTest() {

        System.out.println("Введите ваше имя : ");
        String firstName = ioService.read();
        System.out.println("Введите вашу фамилию : ");
        String lastName = ioService.read();

        Person person = personService.get(firstName, lastName);

        testService.runTest(person);

    }
}
