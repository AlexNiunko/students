package com.epam.niunko.main;

import com.epam.niunko.builder.StudentsSaxBuilder;

import java.io.IOException;

public class MainStudent {
    public static void main(String[] args) throws IOException {
        StudentsSaxBuilder saxBuilder=new StudentsSaxBuilder();
        saxBuilder.buildSetStudent("data\\students.xml");
        System.out.println(saxBuilder.getStudents());
    }
}
