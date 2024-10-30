package tech.pinhos.loucadora.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class PersonDTO {

    @NotBlank
    private String name;

    @NotNull
    @CPF
    private String cpf;

    @Past
    private LocalDate birthDate;

    @NotBlank
    private String cnh;

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotNull @CPF String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @CPF String cpf) {
        this.cpf = cpf;
    }

    public @Past LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Past LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @NotBlank String getCnh() {
        return cnh;
    }

    public void setCnh(@NotBlank String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                ", cnh='" + cnh + '\'' +
                '}';
    }
}
