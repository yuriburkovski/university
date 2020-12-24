package com.botscrew.university.service;

import com.botscrew.university.repository.department.Department;
import com.botscrew.university.repository.department.DepartmentRepository;
import com.botscrew.university.repository.lector.Lector;
import com.botscrew.university.repository.lector.LectorDegree;
import com.botscrew.university.repository.lector.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.botscrew.university.controller.MessageController.wrongInputMessage;

@Service
public class CommandService {

    private LectorRepository lectorRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public CommandService(DepartmentRepository departmentRepository, LectorRepository lectorRepository) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
    }

    private Department findDepartmentByName(String inputName) throws Exception {
        return departmentRepository.findByDepartmentName(inputName);
    }

    public void headOfDepartment(String inputName) throws Exception {
        if (findDepartmentByName(inputName) != null) {
            System.out.println("Head of " + inputName + " department is: "
                    + departmentRepository.findHeadOfDepartment(inputName));
        } else {
            wrongInputMessage();
        }
    }

    public void departmentStats(String inputName) throws Exception {
        if (findDepartmentByName(inputName) != null) {
            System.out.println("ASSISTANT: " + departmentRepository.depStats(LectorDegree.ASSISTANT, inputName));
            System.out.println("ASSOCIATE_PROFESSOR: " + departmentRepository.depStats(LectorDegree.ASSOCIATE_PROFESSOR, inputName));
            System.out.println("PROFESSOR: " + departmentRepository.depStats(LectorDegree.PROFESSOR, inputName));
        } else {
            wrongInputMessage();
        }
    }

    public void averageSalary(String inputName) throws Exception {
        if (findDepartmentByName(inputName) != null) {
            System.out.println("The average salary for " + inputName + " department is: "
                    + departmentRepository.averageSalary(inputName));
        } else {
            wrongInputMessage();
        }
    }

    public void employeeCount(String inputName) throws Exception {
        if (findDepartmentByName(inputName) != null) {
            System.out.println("Count of employee in " + inputName + " department is:"
                    + departmentRepository.employeeCount(inputName));
        } else {
            wrongInputMessage();
        }
    }

    public void globalSearch(String input) throws Exception {
        lectorRepository.findByLectorName(input)
                .stream()
                .map(Lector::getName)
                .forEach(System.out::println);
    }
}