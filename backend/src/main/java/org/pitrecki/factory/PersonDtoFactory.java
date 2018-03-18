package org.pitrecki.factory;

import org.pitrecki.dto.PersonDto;
import org.pitrecki.model.Person;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public class PersonDtoFactory
{
    public static PersonDto makePersonDto(final Person person) {
        return new PersonDto(
            person.getFirstName(),
            person.getLastName(),
            person.getAge(),
            person.getGender()
        );
    }
}
