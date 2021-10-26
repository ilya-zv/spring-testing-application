package ru.appTesting.spring.service;

import ru.appTesting.spring.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestion();
}
