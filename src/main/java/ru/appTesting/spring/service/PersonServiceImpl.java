package ru.appTesting.spring.service;

import org.springframework.stereotype.Service;
import ru.appTesting.spring.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person get(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }
}
