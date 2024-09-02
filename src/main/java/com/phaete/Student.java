package com.phaete;

import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private int postalCode;
    private int age;

    public Student(int id, String firstName, int postalCode, int age) {
        this.id = id;
        this.firstName = firstName;
        this.postalCode = postalCode;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && postalCode == student.postalCode && age == student.age && Objects.equals(firstName, student.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, postalCode, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", postalCode=" + postalCode +
                ", age=" + age +
                '}';
    }
}
