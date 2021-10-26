package ru.appTesting.spring.service;

import ru.appTesting.spring.dao.QuestionDao;
import ru.appTesting.spring.domain.Person;
import ru.appTesting.spring.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TestServiceImpl implements TestService {

    List<Question> testQuestionList;
    IOService ioService;
    QuestionDao questionDao;
    List<String> answer;
    int count;
    String[] variant = {"a", "b", "c", "d"};


    public TestServiceImpl(QuestionDao questionDao, IOService ioService) {
        this.questionDao = questionDao;
        this.ioService = ioService;
    }

    @Override
    public void runTest(Person person) {
        answer = new ArrayList<>();
        System.out.println("Тест начался!_________________");
        testQuestionList = questionDao.getQuestions();
        //starting a test cycle
        for (int i = 1; i < testQuestionList.size(); i++) {

            //output of questions and answer options
            ioService.whrite(
                    i + ") " + testQuestionList.get(i).getQuestion() + "\n    "
                    + testQuestionList.get(0).getVariantAnswer()[0] + ") " + testQuestionList.get(i).getVariantAnswer()[0] + "\n    "
                    + testQuestionList.get(0).getVariantAnswer()[1] + ") " + testQuestionList.get(i).getVariantAnswer()[1] + "\n    "
                    + testQuestionList.get(0).getVariantAnswer()[2] + ") " + testQuestionList.get(i).getVariantAnswer()[2] + "\n    "
                    + testQuestionList.get(0).getVariantAnswer()[3] + ") " + testQuestionList.get(i).getVariantAnswer()[3] + " "
            );
            ioService.whrite("Введите вариант ответа");

            //reading and checking the response
            checkAnswerAndAddList(ioService.read());

        }

        //starting a response check cycle
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(testQuestionList.get(i+1).getCorrectAnswer())) {
                count++;
            }
        }
        System.out.println("Тест завершен!_________________");
        System.out.println(person.getFirstName() +" "+ person.getLastName() + " благодарим за участие");
        System.out.println("Правильных ответов " + count);

        System.out.println("Тест " + (( count >= 3) ? "пройден, поздравляем!" : "провален, не расстраивайтесь. Рекомендуем ознакомиться со списком литературы и попробовать по новой пройти тест через 2 недели"));
    }

    private void checkAnswerAndAddList(String read) {
        if (read.toLowerCase(Locale.ROOT).equals(variant[0])
                | read.toLowerCase(Locale.ROOT).equals(variant[1])
                | read.toLowerCase(Locale.ROOT).equals(variant[2])
                | read.toLowerCase(Locale.ROOT).equals(variant[3])
        )
        {
            answer.add(read.toUpperCase(Locale.ROOT));
        } else {
            System.out.println("Введенное значение не соответствует ни одному ваианту ответа, повторите ввод : ");
            checkAnswerAndAddList(ioService.read());
        }
    }
}
