package com.botscrew.university.repository.lector;

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
class LectorRepositoryTest {
    @Autowired
    private LectorRepository lectorRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Lector lectorFirst =
                new Lector("Ivan Popov", LectorDegree.ASSISTANT, 2000);
        Lector lectorSecond =
                new Lector("Olena Kozlova", LectorDegree.PROFESSOR, 8000);
        testEntityManager.persist(lectorFirst);
        testEntityManager.persist(lectorSecond);
    }

    @Test
    void test_of_save_method_in_repository() {
        Lector lectorToSave =
                new Lector("Test Lector", LectorDegree.ASSOCIATE_PROFESSOR, 500);
        lectorRepository.save(lectorToSave);
        List<Lector> lectors = lectorRepository.findAll();
        assertNotNull(lectors);
        assertEquals(3, lectors.size());
        assertEquals("Test Lector", lectors.get(2).getName());
    }

    @Test
    void return_all_lectors_from_db() {
        List<Lector> lectors = lectorRepository.findAll();
        assertNotNull(lectors);
        assertEquals(2, lectors.size());
    }

    @Test
    void when_find_by_name_only_lector_with_provided_name_should_be_returned() {
        String name = "Ivan Popov";
        List<Lector> findLector = lectorRepository.findByLectorName(name);

        assertNotNull(findLector);
        assertTrue(findLector.size() == 1);
        assertEquals(LectorDegree.ASSISTANT, findLector.get(0).getDegree());
    }

    @Test
    void when_find_lector_does_not_contain_in_db_then_empty_list_should_be_thrown() throws Exception {
        String name = "Wrong Name";
        List<Lector> findLector = lectorRepository.findByLectorName(name);

        assertTrue(findLector.isEmpty());
    }
}