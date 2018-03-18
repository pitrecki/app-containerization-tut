package org.pitrecki.service;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pitrecki.model.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
class PersonDetailsGeneratorServiceImplTest
{
    private static final int SIZE = 10;

    private final PersonDetailsGeneratorService sut = new PersonDetailsGeneratorServiceImpl();

    @Test
    @DisplayName("should return collection with expected size")
    void testGenerateShouldReturnExpectedSize() {
        List<Person> actual = sut.generate(SIZE);
        assertThat(actual).hasSize(SIZE);
    }

    @Test
    @DisplayName("should return collection with proper generated persons")
    void testGenerateShouldReturnCollectionWithNotEmptyFields() {
        List<Person> actual = sut.generate(SIZE);
        assertThat(actual).flatExtracting("age", "firstName", "lastName", "gender").isNotNull();
    }
}