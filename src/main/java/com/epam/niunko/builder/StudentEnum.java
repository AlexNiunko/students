package com.epam.niunko.builder;

public enum StudentEnum {
    STUDENTS("students"),
    STUDENT("student"),
    ID("id"),
    LOGIN("login"),
    FACULTY("faculty"),
    NAME("name"),
    TELEPHONE("telephone"),
    COUNTRY("country"),
    CITY("city"),
    STREET("street"),
    ADDRESS("address");
    private String value;

    StudentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
