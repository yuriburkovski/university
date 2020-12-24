package com.botscrew.university.config;

import com.botscrew.university.UniversityApplication;
import com.botscrew.university.repository.department.Department;
import com.botscrew.university.repository.department.DepartmentRepository;
import com.botscrew.university.repository.lector.Lector;
import com.botscrew.university.repository.lector.LectorDegree;
import com.botscrew.university.repository.lector.LectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Order(value = 1)
public class DatabaseLoader implements CommandLineRunner {
    private static Logger LOG = LoggerFactory
            .getLogger(UniversityApplication.class);

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Autowired
    public DatabaseLoader(DepartmentRepository departmentRepository, LectorRepository lectorRepository) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Setup Database...");
        Department departmentEcon = new Department("Economics", "Oleg Skrypka");
        Department departmentMath = new Department("Mathematics", "Ivan Petrov");
        Department departmentPhil = new Department("Philology", "Yulia Golovan");

        Set<Lector> lectorsEcon = new HashSet<>();
        Set<Lector> lectorsMath = new HashSet<>();
        Set<Lector> lectorsPhil = new HashSet<>();

        Lector lector1 = new Lector("Vasyl Stus", LectorDegree.ASSISTANT, 5000);
        Lector lector2 = new Lector("Oleg Skrypka", LectorDegree.PROFESSOR, 12000);
        Lector lector3 = new Lector("Petro Ivanov", LectorDegree.ASSOCIATE_PROFESSOR, 8000);
        Lector lector4 = new Lector("Ivan Petrov", LectorDegree.PROFESSOR, 12000);
        Lector lector5 = new Lector("Alex Rodas", LectorDegree.ASSOCIATE_PROFESSOR, 8000);
        Lector lector6 = new Lector("Yulia Golovan", LectorDegree.PROFESSOR, 12000);
        Lector lector7 = new Lector("Olena Bystra", LectorDegree.ASSOCIATE_PROFESSOR, 8000);
        Lector lector8 = new Lector("Ivan Bystry", LectorDegree.ASSISTANT, 5000);

        lectorsEcon.add(lector2);
        lectorsEcon.add(lector3);
        lectorsEcon.add(lector1);
        lectorsMath.add(lector4);
        lectorsMath.add(lector5);
        lectorsMath.add(lector1);
        lectorsPhil.add(lector6);
        lectorsPhil.add(lector7);
        lectorsPhil.add(lector8);

        departmentEcon.setLectors(lectorsEcon);
        departmentMath.setLectors(lectorsMath);
        departmentPhil.setLectors(lectorsPhil);
        lectorRepository.save(lector1);
        lectorRepository.save(lector2);
        lectorRepository.save(lector3);
        lectorRepository.save(lector4);
        lectorRepository.save(lector5);
        lectorRepository.save(lector6);
        lectorRepository.save(lector7);
        lectorRepository.save(lector8);
        departmentRepository.save(departmentEcon);
        departmentRepository.save(departmentMath);
        departmentRepository.save(departmentPhil);
        LOG.info("Database is ready.");
    }
}