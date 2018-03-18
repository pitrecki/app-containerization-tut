package org.pitrecki.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.pitrecki.model.Gender;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public class PersonDto implements Serializable
{
    private static final long serialVersionUID = -5787383354796928515L;

    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Gender gender;

    @JsonCreator
    public PersonDto(@JsonProperty(value = "firstName", required = true) String firstName,
                     @JsonProperty(value = "lastName", required = true) String lastName,
                     @JsonProperty(value = "age", required = true) Integer age,
                     @JsonProperty(value = "gender", required = true) Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(firstName, personDto.firstName) &&
                Objects.equals(lastName, personDto.lastName) &&
                Objects.equals(age, personDto.age) &&
                gender == personDto.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender);
    }

    @Override
    public String toString() {
        return "PersonDto{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}