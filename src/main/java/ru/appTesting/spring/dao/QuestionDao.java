package ru.appTesting.spring.dao;

import ru.appTesting.spring.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getQuestions();

}
