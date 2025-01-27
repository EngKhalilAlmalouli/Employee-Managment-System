package EmployeesManagement.EmployeesManagement.department;

import EmployeesManagement.EmployeesManagement.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
//@Data
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true, name = "name")
    private String name;
    private String description;


    @OneToMany
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
