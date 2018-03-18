package org.pitrecki.util;

import io.github.benas.randombeans.api.Randomizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
class AgeRandomizerTest
{
    private static final Integer MIN_BOUND = 1;
    private static final Integer MAX_BOUND = 100;

    private final Randomizer<Integer> sut = new AgeRandomizer();

    @Test
    @DisplayName("should randomize age in expected bounds")
    void testRandomizeAgeShouldReturnAgeInExpectedBounds() {
        Integer actual = sut.getRandomValue();
        assertThat(actual).isBetween(MIN_BOUND, MAX_BOUND);
    }
}