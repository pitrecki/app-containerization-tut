package org.pitrecki.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.benas.randombeans.api.EnhancedRandom;
import org.pitrecki.model.Person;
import org.pitrecki.util.RandomizerUtils;
import org.springframework.stereotype.Service;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
@Service
public class PersonDetailsGeneratorServiceImpl implements PersonDetailsGeneratorService
{
    @Override
    public List<Person> generate(int amount) {
        EnhancedRandom rand = RandomizerUtils.defaultConfig();
        return rand.objects(Person.class, amount)
            .collect(Collectors.toList());
    }
}
