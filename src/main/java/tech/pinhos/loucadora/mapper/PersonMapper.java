package tech.pinhos.loucadora.mapper;

import org.mapstruct.Mapper;
import tech.pinhos.loucadora.dto.PersonDTO;
import tech.pinhos.loucadora.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO toDto(Person person);

    Person toEntity(PersonDTO personDTO);

}
