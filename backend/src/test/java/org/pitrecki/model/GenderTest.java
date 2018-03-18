package org.pitrecki.model;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
class GenderTest
{
    private static final Pattern LOWER_CASE_PATTERN = Pattern.compile("\\p{javaLowerCase}+");

    @Test
    @DisplayName("should return string with lowercase")
    void testToStringShouldReturnStringWithLowerCase() {
        Arrays.stream(Gender.values())
            .map(Gender::toString)
            .forEach(s -> assertThat(s).containsPattern(LOWER_CASE_PATTERN));
    }
}