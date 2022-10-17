package com.epam.niunko.entity;

public class Student {

private String login;
private String name;
private String faculty;
private int telephone;
private Address address=new Address();

    public Student(String login, String name, String faculty, int telephone, Address address) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }
    public Student(){

    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
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
        sb.append("login='").append(login).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", faculty='").append(faculty).append('\'');
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
