package org.example.task4;

import java.io.Serializable;

public class TestClass implements Serializable{
    private static String name;
    private static String surname;

    public TestClass(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;

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



}
