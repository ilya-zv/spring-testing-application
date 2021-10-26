package ru.appTesting.spring.service;

import ru.appTesting.spring.dao.QuestionDao;
import ru.appTesting.spring.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestion() {
        return questionDao.getQuestions();
    }



}
