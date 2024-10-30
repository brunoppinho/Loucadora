package tech.pinhos.loucadora.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.pinhos.loucadora.dto.PersonDTO;
import tech.pinhos.loucadora.service.CreatePersonService;
import tech.pinhos.loucadora.service.RetrievePersonService;

@RestController()
@RequestMapping("api/v1/persons")
public class PersonController {

    private final CreatePersonService createPersonService;
    private final RetrievePersonService retrievePersonService;

    public PersonController(CreatePersonService createPersonService, RetrievePersonService retrievePersonService) {
        this.createPersonService = createPersonService;
        this.retrievePersonService = retrievePersonService;
    }

    @PostMapping()
    public PersonDTO createPerson(@Valid @RequestBody PersonDTO person) {
        return createPersonService.execute(person);
    }

    @GetMapping("/{cpf}")
    public PersonDTO retrievePerson(@PathVariable String cpf) {
        return retrievePersonService.retrievePersonByCPF(cpf);
    }

    @GetMapping("")
    public Page<PersonDTO> retrieveAllPersonPersons(Pageable pageable) {
        return retrievePersonService.retrieveAll(pageable);
    }
}
