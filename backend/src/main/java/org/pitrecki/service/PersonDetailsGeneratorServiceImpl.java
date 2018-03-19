package org.pitrecki.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.benas.randombeans.api.EnhancedRandom;
import org.pitrecki.model.Person;
import org.pitrecki.util.RandomizerUtils;
import org.springframework.stereotype.Service;

import static java.text.MessageFormat.format;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
@Service
public class PersonDetailsGeneratorServiceImpl implements PersonDetailsGeneratorService
{
    private static final int MAXIMUM_CAPACITY = 100;

    @Override
    public List<Person> generate(int amount) {
        validateInput(amount);
        EnhancedRandom rand = RandomizerUtils.defaultConfig();
        return rand.objects(Person.class, amount)
            .collect(Collectors.toList());
    }

    private void validateInput(int amount) {
        if (amount > MAXIMUM_CAPACITY) {
            String err  = format("The allowed amount has been exceeded, max value: {0}, current value: {1}",
                    MAXIMUM_CAPACITY, amount);
            throw new IllegalArgumentException(err);
        }
    }
}
