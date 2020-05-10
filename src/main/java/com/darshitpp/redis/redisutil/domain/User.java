package com.darshitpp.redis.redisutil.domain;

import java.util.Date;
import java.util.Objects;

public class User {

    private final String firstName;
    private final String lastName;
    private final Date birthday;


    public User(String firstName, String lastName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday);
    }
}
