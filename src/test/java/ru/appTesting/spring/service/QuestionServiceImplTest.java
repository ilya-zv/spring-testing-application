package ru.appTesting.spring.service;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.appTesting.spring.dao.QuestionDao;

class QuestionServiceImplTest {

    private static QuestionService questionService;

    @BeforeAll
    public static void globalSetUp() {
        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        questionService = new QuestionServiceImpl(questionDao);

    }

    @Test
    @DisplayName("Сервис должен возвращать не null")
    void serviceShouldReturnNotNull() {
        Assertions.assertNotNull(questionService.getQuestion());
    }

    @Test
    @DisplayName("Сервис должен возвращать ноль объектов в листе")
    void serviceShouldReturnInListZeroObject() {
        Assertions.assertEquals(0, questionService.getQuestion().size());
    }
}