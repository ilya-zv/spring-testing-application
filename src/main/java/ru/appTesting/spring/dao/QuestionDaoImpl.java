package ru.appTesting.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import ru.appTesting.spring.domain.Question;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDaoImpl implements QuestionDao {

    @Value("${nameTestQuestionFile}")
    private String nameTestQuestionFile;

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        InputStream in = getClass().getResourceAsStream("/" + nameTestQuestionFile);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        List<String> questionList = buffer.lines().collect(Collectors.toList());

        for (String question : questionList
        ) {
            String[] questionParse = question.split(",");
            questions.add(new Question(
                    Integer.parseInt(questionParse[0]), questionParse[1], new String[]{questionParse[2], questionParse[3], questionParse[4], questionParse[5]}, questionParse[6]));
        }
        return questions;
    }
}
