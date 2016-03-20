package com.ashish;

/**
 * @author Ashish Sharma
 *         on 10/23/2015.
 */
public class Employee {

    private String name;
    private int age;
    private int id;
    private int salary;

    public Employee(String name, int id, int salary, int age) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("%s\t%d\t%d\t%d", name, id, age, salary);
    }
}
