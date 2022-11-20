package com.employee.lessontestingmockito.service;

import com.employee.lessontestingmockito.model.Employee;
import com.employee.lessontestingmockito.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        this.employeeService = new EmployeeService();
        EmployeeRequest employee1 = new EmployeeRequest("Иванов", "Александр", 2, 50000);
        employeeService.addEmployee(employee1);
        EmployeeRequest employee2 = new EmployeeRequest("Петрова", "Мария", 1, 70000);
        employeeService.addEmployee(employee2);
        EmployeeRequest employee3 = new EmployeeRequest("Демидова", "Ольга", 2, 55000);
        employeeService.addEmployee(employee3);
        EmployeeRequest employee4 = new EmployeeRequest("Хальзов", "Александр", 3, 50000);
        employeeService.addEmployee(employee4);
        EmployeeRequest employee5 = new EmployeeRequest("Тимченко", "Дмитрий", 2, 45000);
        employeeService.addEmployee(employee5);
    }

    @Test
    void addEmployee() {
        EmployeeRequest employeeRequest = new EmployeeRequest("Иванов", "Александр", 1, 50000);
        Employee employee = employeeService.addEmployee(employeeRequest);
        assertEquals(employeeRequest.getFirstName(), employee.getFirstName());
        assertEquals(employeeRequest.getLastName(), employee.getLastName());
        assertEquals(employeeRequest.getSalary(), employee.getSalary());
        assertEquals(employeeRequest.getDepartament(), employee.getDepartament());
    }

    @Test
    public void getSalarySum() {
        int summa = employeeService.getSalarySum();
        assertEquals(summa, 270000);
    }

    @Test
    public void getEmployeesDepartament() {
        int number = (int) employeeService.getAllEmployee().stream().filter(d -> d.getDepartament() == 2).count();
        assertEquals(number, 3);
    }

    @Test
    public void getSalaryMin() {
        Employee employee = employeeService.getSalaryMin();
        int minSumma = employee.getSalary();
        assertEquals(minSumma, 45000);
    }

    @Test
    public void getSalaryMax() {
        Employee employee = employeeService.getSalaryMax();
        int maxSumma = employee.getSalary();
        assertEquals(maxSumma, 70000);
    }

    @Test
    public void getSalaryAverage() {
        int averageSalary = employeeService.getSalaryAverage();
        assertEquals(averageSalary, 54000);
    }

    @Test
    public void getEmployeeSalaryHigherAverage() {
        ArrayList<Employee> list = new ArrayList<>(employeeService.getEmployeeSalaryHigherAverage());
        assertEquals(list.size(), 2);
    }

}