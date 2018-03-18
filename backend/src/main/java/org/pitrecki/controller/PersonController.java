package org.pitrecki.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.pitrecki.dto.PersonDto;
import org.pitrecki.factory.PersonDtoFactory;
import org.pitrecki.model.Person;
import org.pitrecki.service.PersonDetailsGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
@RestController
public class PersonController
{
    private final PersonDetailsGeneratorService detailsGeneratorService;

    @Autowired
    public PersonController(PersonDetailsGeneratorService detailsGeneratorService) {
        this.detailsGeneratorService = detailsGeneratorService;
    }

    @RequestMapping(value = "/api/people_data", method = GET)
    public ResponseEntity<List<PersonDto>> generatePersonsData(
            @RequestParam(name = "amount", defaultValue = "1") Integer amount) {
        List<Person> people = detailsGeneratorService.generate(amount);
        return ResponseEntity.ok(performMapping(people));
    }

    private List<PersonDto> performMapping(List<Person> people) {
        return people.parallelStream()
            .map(PersonDtoFactory::makePersonDto)
            .collect(Collectors.toList());
    }
}
