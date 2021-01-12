package com.botscrew.university.repository.lector;

import com.botscrew.university.repository.department.Department;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Lector")
@Table(name = "LECTOR")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private LectorDegree degree;

    private int salary;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments = new HashSet<>();

    public Lector() {
    }

    public Lector(String name, LectorDegree degree, int salary) {
        this.name = name;
        this.degree = degree;
        this.salary = salary;
    }

    public Lector(String name, LectorDegree degree, int salary, Set<Department> departments) {
        this.name = name;
        this.degree = degree;
        this.salary = salary;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LectorDegree getDegree() {
        return degree;
    }

    public void setDegree(LectorDegree degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return id == lector.id &&
                salary == lector.salary &&
                Objects.equals(name, lector.name) &&
                degree == lector.degree &&
                Objects.equals(departments, lector.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, degree, salary, departments);
    }
}
