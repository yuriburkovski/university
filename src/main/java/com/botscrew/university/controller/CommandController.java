package com.botscrew.university.controller;

import com.botscrew.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

import static com.botscrew.university.controller.MessageController.*;

@Controller
@Order(value = 2)
public class CommandController implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    private final CommandService commandService;

    @Autowired
    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    public void findDepartmentByName(String input) {
        try {
            commandService.headOfDepartment(input);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void departmentStats(String input) {
        try {
            commandService.departmentStats(input);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void averageSalary(String input) {
        try {
            commandService.averageSalary(input);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void employeeCount(String input) {
        try {
            commandService.employeeCount(input);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void globalSearch(String input) {
        try {
            commandService.globalSearch(input);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        askForInput();
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                chooseDepartmentMessage();
                findDepartmentByName(scanner.nextLine());
                exit();
                break;
            case "2":
                chooseDepartmentMessage();
                departmentStats(scanner.nextLine());
                exit();
                break;
            case "3":
                chooseDepartmentMessage();
                averageSalary(scanner.nextLine());
                exit();
                break;
            case "4":
                chooseDepartmentMessage();
                employeeCount(scanner.nextLine());
                exit();
                break;
            case "5":
                System.out.println("Search: ");
                globalSearch(scanner.nextLine());
                exit();
                break;
            default:
                wrongInputMessage();
                run();
                break;
        }
    }

    public void exit() throws Exception {
        System.out.println("Do you want exit: Y/N ?");
        String choice = scanner.nextLine().toLowerCase();
        switch (choice) {
            case "y":
                System.out.println("Good bye");
                System.exit(0);
                break;
            case "n":
                run();
                break;
            default:
                wrongInputMessage();
                exit();
                break;
        }
    }
}