package com.epam.niunko.entity;

public class Address {

private String country;
private String city;
private String street;

public Address(){
}

public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
}

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("country='").append(country).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
