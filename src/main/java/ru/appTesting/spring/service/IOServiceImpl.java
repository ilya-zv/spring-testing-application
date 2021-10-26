package ru.appTesting.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOServiceImpl implements IOService {
    @Override
    public String read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
        return "0";
    }

    @Override
    public void whrite(String text) {
        System.out.println(text);
    }
}
