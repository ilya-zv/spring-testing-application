package ru.appTesting.spring.service;

import ru.appTesting.spring.domain.Person;

public class PersonServiceImpl implements PersonService {
    @Override
    public Person get(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }
}
