package org.pitrecki.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pitrecki.dto.PersonDto;
import org.pitrecki.model.Gender;
import org.pitrecki.model.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
class PersonDtoFactoryTest
{
    private static final String FIRST_NAME = "Jan";
    private static final String LAST_NAME = "Kowalski";
    private static final Integer AGE = 10;
    private static final Gender GENDER = Gender.MALE;
    private static final Person PERSON = new Person(FIRST_NAME, LAST_NAME, AGE, GENDER);

    @Test
    @DisplayName("should return expected class type")
    void testMakePersonDtoShouldRetunExpectedClassType() {
        PersonDto actual = PersonDtoFactory.makePersonDto(PERSON);
        assertThat(actual)
            .isOfAnyClassIn(PersonDto.class)
            .isNotOfAnyClassIn(Person.class);
    }

    @Test
    @DisplayName("should contains expected field values")
    void testMakePersonDtoShouldContainsExpectedValues() {
        PersonDto actual = PersonDtoFactory.makePersonDto(PERSON);
        assertThat(actual)
                .extracting(PersonDto::getAge, PersonDto::getFirstName, PersonDto::getLastName, PersonDto::getGender)
                .containsExactly(AGE, FIRST_NAME, LAST_NAME, GENDER);
    }
}