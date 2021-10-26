package ru.appTesting.spring.domain;

import java.util.Arrays;

public class Question {
    private int id;
    private String question;
    private String[] variantAnswer;
    private String correctAnswer;



    public Question(int id, String question, String[] variantAnswer, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.variantAnswer = variantAnswer;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getVariantAnswer() {
        return variantAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", variantAnswer=" + Arrays.toString(variantAnswer) +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
