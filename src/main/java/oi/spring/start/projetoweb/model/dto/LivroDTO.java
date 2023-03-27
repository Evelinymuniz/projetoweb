package oi.spring.start.projetoweb.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import oi.spring.start.projetoweb.model.entity.EditoraEntity;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor

public class LivroDTO {

    private Integer id;
    @NonNull
    private String nome;

    private EditoraDTO editora;

    private CategoriaDTO categoria;
    @NotBlank(message="Nome deve conter algum valor")
    @Size(max = 13, min = 13)
    private Long isbn;



}
