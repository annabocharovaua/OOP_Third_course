package org.example.task4;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{
    //load the class from the file system
    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] classData = null;
        try {
            //loads the byte code data from the file
            classData = loadClassFileData(file);
            //convert byte array into a Class
            Class defineClass = defineClass(name, classData, 0, classData.length);
            resolveClass(defineClass);
            return defineClass;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class ' " + name + "'");
        if(name.startsWith(".java")) {
            System.out.println("loading Class using CustomClassLoader");
            return getClass(name);
        }
        return super.loadClass(name);
    }

    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream input = new DataInputStream(stream);
        input.readFully(buff);
        input.close();
        return buff;
    }


}
