package org.example.task4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Printer {
    private final Class<?> data;

    public Printer(String name) {
        try {
            CustomClassLoader loader = new CustomClassLoader();
            data = loader.loadClass(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Class<?> getClassData() {
        return data;
    }

    public void printName() {
        System.out.println("Name : " + data.getName());
    }

    public void printPackege() {
        System.out.println("Package : " +data.getPackage().getName());
    }

    public void printSuperClasses() {
        Class<?> superClass = data.getSuperclass();
        System.out.println("Super classes : ");
        while(superClass!=null){
            System.out.println(superClass.getName());
            superClass = superClass.getSuperclass();
        }
    }

    public void printInterfaces() {
        Class<?>[] interfaces = data.getInterfaces();
        System.out.println("Interfaces : ");
        for(Class<?> implemented : interfaces) {
            System.out.println(implemented.getName());
        }
    }

    public void printConstructors() {
        System.out.println("Constructors: ");
        Constructor<?>[] constructors = data.getConstructors();

        for(Constructor<?> constructor: constructors) {
            System.out.println(constructor);
        }
    }

    public void printFields() {
        System.out.println("Fields : ");
        Field[] fields = data.getDeclaredFields();

        for(Field field: fields){
            System.out.println(field);
        }
    }

    public void printMethods() {
        System.out.println("Methods: ");
        Method[] methods = data.getMethods();

        for(Method method: methods){
            System.out.println(method);
        }
    }

    public  void print() {
        printName();
        printPackege();
        printSuperClasses();
        printInterfaces();
        printConstructors();
        printFields();
        printMethods();
    }

}
