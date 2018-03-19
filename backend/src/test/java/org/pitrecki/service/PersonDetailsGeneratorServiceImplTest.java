package org.pitrecki.service;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.pitrecki.model.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
class PersonDetailsGeneratorServiceImplTest
{
    private static final int SIZE = 10;
    private static final int SIZE_IN_BOUND = 100;
    private static final int SIZE_OVERFLOW = SIZE_IN_BOUND + 1;

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

    @Test
    @DisplayName("should throws exception when amount excedeed max value")
    void testGenerateShouldThrowsExceptionWhenAmountOF() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sut.generate(SIZE_OVERFLOW))
            .withNoCause()
            .withMessageContaining("exceeded");
    }

    @Test
    @Tag("slow")
    @DisplayName("should return collection when amount is equal to max acceptable val")
    void testGenerateShouldSuccedWhenMaxAmountNotExceeded() {
        List<Person> actual = sut.generate(SIZE_IN_BOUND);
        assertThat(actual).isNotNull().hasSize(SIZE_IN_BOUND);
    }
}