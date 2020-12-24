package com.botscrew.university.repository.department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department departmentFirst =
                new Department("TestDep", "Head First");
        Department departmentsSecond =
                new Department("TestDep2", "Head Second");
        testEntityManager.persist(departmentFirst);
        testEntityManager.persist(departmentsSecond);
    }

    @Test
    void return_all_departments_from_db() {
        List<Department> departments = departmentRepository.findAll();
        assertNotNull(departments);
        assertEquals(2, departments.size());
    }

    @Test
    void test_of_save_method_in_department_repository() {
        Department departmentToSave =
                new Department("Test Department", "Test Head");
        departmentRepository.save(departmentToSave);
        List<Department> departments = departmentRepository.findAll();
        assertNotNull(departments);
        assertEquals(3, departments.size());
        assertEquals("Test Department", departments.get(2).getDepartmentName());
    }

    @Test
    void when_find_by_name_only_department_with_provided_name_should_be_returned() {
        String name = "TestDep";
        Department findDepartment = departmentRepository.findByDepartmentName(name);
        assertNotNull(findDepartment);
        assertEquals("Head First", findDepartment.getHeadOfDepartment());
    }

    @Test
    void when_find_by_head_of_department_only_head_with_provided_name_should_be_returned() {
        String name = "TestDep2";
        String findedDepartment = departmentRepository.findHeadOfDepartment(name);
        assertNotNull(findedDepartment);
        assertEquals("Head Second", findedDepartment);
    }

    @Test
    void when_find_department_does_not_contain_in_db_then_empty_list_should_be_thrown() {
        String name = "Wrong Name";
        Department findDepartment = departmentRepository.findByDepartmentName(name);
        assertNull(findDepartment);
    }
}