package com.ww.java8.module;

import java.util.Objects;

/**
 * @author WangWei
 * @Title: Employee
 * @ProjectName java8
 * @date 2019/1/11 10:43
 * @description:
 */
public class Employee {

    private String name;

    private Integer age;

    private Double salary;

    private Status status;

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }

    public Employee() {
    }

    public Employee(Integer age, Double salary) {
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, Integer age, Double salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary) &&
                status == employee.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, salary, status);
    }
}
