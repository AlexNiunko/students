package com.epam.niunko.entity;

import java.util.StringJoiner;

public class Student {

private String id;
private String login;
private String faculty;
private String name;
private int telephone;
private Address address=new Address();

    public Student() {
        this.id = id;
        this.login = login;
        this.faculty = faculty;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getName() {
        return name;
    }

    public int getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id='").append(id).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", faculty='").append(faculty).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }
}
