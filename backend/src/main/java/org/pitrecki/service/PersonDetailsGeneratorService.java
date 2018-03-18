package org.pitrecki.service;

import java.util.List;

import org.pitrecki.model.Person;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public interface PersonDetailsGeneratorService
{
    List<Person> generate(int amount);
}
