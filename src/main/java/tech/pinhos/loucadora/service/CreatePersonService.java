package tech.pinhos.loucadora.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.pinhos.loucadora.LoucadoraApplication;
import tech.pinhos.loucadora.dto.PersonDTO;
import tech.pinhos.loucadora.mapper.PersonMapper;
import tech.pinhos.loucadora.repository.PersonRepository;

import java.time.LocalDate;
import java.util.logging.Logger;

@Service
public class CreatePersonService {

    Logger logger = Logger.getLogger(LoucadoraApplication.class.getName());

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public CreatePersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO execute(PersonDTO person) {
        logger.info(String.format("Criando pessoa %s", person));
        if (person.getBirthDate() == null || person.getBirthDate().isAfter(LocalDate.now().minusYears(18))) {
            throw new RuntimeException();
        }
        return personMapper.toDto(personRepository.save(personMapper.toEntity(person)));
    }
}
