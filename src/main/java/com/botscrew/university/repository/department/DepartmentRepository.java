package com.botscrew.university.repository.department;

import com.botscrew.university.repository.lector.LectorDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("FROM Department WHERE departmentName=?1")
    Department findByDepartmentName(String depName);

    @Query("SELECT headOfDepartment FROM Department WHERE departmentName=?1")
    String findHeadOfDepartment(String depName);

    @Query("SELECT count(l) FROM Department d JOIN d.lectors l WHERE l.degree=?1 AND d.departmentName=?2")
    Integer depStats(LectorDegree degree, String depName);

    @Query("SELECT AVG(l.salary) FROM Department d JOIN d.lectors l WHERE d.departmentName=:depName")
    Double averageSalary(@Param("depName") String depName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.lectors l WHERE d.departmentName=:depName")
    Integer employeeCount(String depName);

}
