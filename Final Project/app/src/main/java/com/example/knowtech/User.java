package com.example.knowtech;

import android.os.Bundle;

public class User {
    int id, age;
    String email, firstname, lastname, gender, birthdate;

    public User(int id, String email, String firstname, String lastname, String gender, String birthdate, int age) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bundle getBundleInformation() {
        Bundle information = new Bundle();

        information.putInt("id", id);
        information.putInt("age", age);
        information.putString("email", email);
        information.putString("firstname", firstname);
        information.putString("lastname", lastname);
        information.putString("gender", gender);
        information.putString("birthdate", birthdate);

        return information;
    }
}