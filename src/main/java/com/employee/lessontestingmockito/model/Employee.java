package com.employee.lessontestingmockito.model;

public class Employee {
    private static int count;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int departament;
    private final int salary;

    public Employee(String firsName, String lastName, int departament, int salary) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.departament = departament;
        this.salary = salary;
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartament() {
        return departament;
    }

    public int getSalary() {
        return salary;
    }

}
