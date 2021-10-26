package ru.appTesting.spring.service;

import org.springframework.stereotype.Service;
import ru.appTesting.spring.dao.QuestionDao;
import ru.appTesting.spring.domain.Question;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestion() {
        return questionDao.getQuestions();
    }



}
