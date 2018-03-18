package org.pitrecki.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
class PersonTest
{
    private static final String FIRST_NAME = "Jan";
    private static final String LAST_NAME = "Kowalski";
    private static final Integer AGE = 10;
    private static final Gender GENDER = Gender.MALE;

    private final Person sut = new Person(FIRST_NAME, LAST_NAME, AGE, GENDER);

    @Test
    @DisplayName("should return expected firstname")
    void testPersonShouldReturnExpectedFirstName() {
        assertThat(sut.getFirstName()).isEqualTo(FIRST_NAME);
    }

    @Test
    @DisplayName("should return expected lastname")
    void testPersonShouldReturnExpectedLastName() {
        assertThat(sut.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    @DisplayName("should return expected age")
    void testPersonShouldReturnExpectedAge() {
        assertThat(sut.getAge()).isEqualTo(AGE);
    }

    @Test
    @DisplayName("should return expected gender")
    void testPersonShouldReturnExpectedGender() {
        assertThat(sut.getGender()).isEqualByComparingTo(GENDER);
    }
}