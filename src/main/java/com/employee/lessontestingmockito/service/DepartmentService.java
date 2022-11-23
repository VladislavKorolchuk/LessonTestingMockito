package com.employee.lessontestingmockito.service;

import com.employee.lessontestingmockito.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Список сотруников по департаменту
    public Collection<Employee> getEmployeesDepartament(int departament) {
        Collection<Employee> collect = employeeService.getAllEmployee().stream().
                filter(e -> e.getDepartament() == departament).
                collect(Collectors.toList());
        return collect;
    }

    // Сумма зарплат сотруников по департаменту
    public int getSummaSalariesEmployeeByDepartament(int departament) {
        return employeeService.getAllEmployee().stream().
                filter(e -> e.getDepartament() == departament).
                collect(Collectors.summingInt(s -> s.getSalary()));

    }
}
