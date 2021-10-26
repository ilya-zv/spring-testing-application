package ru.appTesting.spring.service;

import ru.appTesting.spring.domain.Person;

public interface PersonService {
    Person get(String firstName, String lastName);
}
