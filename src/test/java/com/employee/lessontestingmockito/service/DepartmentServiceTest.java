package com.employee.lessontestingmockito.service;

import com.employee.lessontestingmockito.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        when(employeeService.getAllEmployee())
                .thenReturn(List.of(
                        new Employee("Иванов", "Александр", 2, 50000),
                        new Employee("Петрова", "Мария", 1, 70000),
                        new Employee("Демидова", "Ольга", 2, 55000),
                        new Employee("Хальзов", "Александр", 3, 50000),
                        new Employee("Тимченко", "Дмитрий", 2, 45000)
                ));
    }

    @Test
    void getEmployeesDepartament() {
        ArrayList<Employee> listEmployee = new ArrayList<>(this.departmentService.getEmployeesDepartament(2));
        int numEmployees = listEmployee.size();
        assertEquals(numEmployees, 3);
    }

    @Test
    void getSummaSalariesEmployeeByDepartament() {
        int summa = departmentService.getSummaSalariesEmployeeByDepartament(2);
        assertEquals(summa, 150000);
    }

}