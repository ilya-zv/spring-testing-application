package ru.appTesting.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.appTesting.spring.service.IOService;
import ru.appTesting.spring.service.RunService;

import java.util.Locale;

@ShellComponent
public class ShellCommandLine {
    private RunService runService;
    private IOService ioService;

    public ShellCommandLine(RunService runService, IOService ioService) {
        this.runService = runService;
        this.ioService = ioService;
    }

    @ShellMethod("User login and password")
    public void login(String p) {
        if(p.equals("admin")) {
            ioService.whrite("Здравствуйте, желаете пройти тест? (введите да/нет) : ");
            if (ioService.read().toLowerCase(Locale.ROOT).equals("да")) {
                runService.runTest();
            } else {
                ioService.whrite("Для выхода введите \"exit\" ");
            }
        } else {
            System.out.println("Вы ввели неверный логин или пароль, попробуйте снова");
        }
    }
}
