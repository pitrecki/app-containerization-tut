package org.pitrecki.util;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

import static java.nio.charset.Charset.forName;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public class RandomizerUtils
{
    private RandomizerUtils() {
    }

    public static EnhancedRandom defaultConfig() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
            .seed(123L)
            .objectPoolSize(100)
            .randomizationDepth(3)
            .charset(forName("UTF-8"))
            .stringLengthRange(5, 50)
            .collectionSizeRange(1, 10)
            .scanClasspathForConcreteTypes(true)
            .overrideDefaultInitialization(false)
            .build();
    }
}
