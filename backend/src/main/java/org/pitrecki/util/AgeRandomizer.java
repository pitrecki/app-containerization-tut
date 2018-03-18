package org.pitrecki.util;

import java.util.concurrent.ThreadLocalRandom;

import io.github.benas.randombeans.api.Randomizer;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public class AgeRandomizer implements Randomizer<Integer>
{
    private static final Integer MIN = 1;
    private static final Integer MAX = 100;

    @Override
    public Integer getRandomValue() {
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }
}
