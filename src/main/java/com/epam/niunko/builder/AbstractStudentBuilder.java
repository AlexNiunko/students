package com.epam.niunko.builder;

import com.epam.niunko.entity.Student;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStudentBuilder {
    protected Set<Student> students;

    public AbstractStudentBuilder() {
        students = new HashSet<Student>();
    }

    public AbstractStudentBuilder(Set<Student> students) {
        this.students = students;
    }

    public abstract void buildSetupStudents(String filename);
}
