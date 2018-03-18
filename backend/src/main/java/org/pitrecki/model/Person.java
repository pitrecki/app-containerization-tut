package org.pitrecki.model;

import java.util.Objects;

import io.github.benas.randombeans.annotation.Randomizer;
import io.github.benas.randombeans.randomizers.FirstNameRandomizer;
import io.github.benas.randombeans.randomizers.LastNameRandomizer;
import org.pitrecki.util.AgeRandomizer;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public class Person
{
    @Randomizer(value = FirstNameRandomizer.class)
    private final String firstName;

    @Randomizer(value = LastNameRandomizer.class)
    private final String lastName;

    @Randomizer(value = AgeRandomizer.class)
    private final Integer age;
    
    private final Gender gender;

    public Person(String firstName, String lastName, Integer age, Gender gender) {
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
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(age, person.age) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender);
    }

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
