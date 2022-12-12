package org.example.task1;

import java.io.Serializable;

public class TestClass implements Serializable{
    private static String name;
    private static String surname;
    private static int age;

    public TestClass(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge)  {
        this.age = newAge;
    }

    @Override

    public String toString() {
        return "name = " + name +", surname = "+ surname + ", age = " + age;
    }

}

