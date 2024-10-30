package tech.pinhos.loucadora.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.pinhos.loucadora.dto.PersonDTO;
import tech.pinhos.loucadora.mapper.PersonMapper;
import tech.pinhos.loucadora.repository.PersonRepository;

@Service
public class RetrievePersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public RetrievePersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO retrievePersonByCPF(String cpf) {
        return personMapper.toDto(personRepository.findByCpf(cpf).orElseThrow());
    }

    public Page<PersonDTO> retrieveAll(Pageable pageable) {
        return personRepository
                .findAll(pageable)
                .map(personMapper::toDto);
    }
}
