package oi.spring.start.projetoweb.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditoraDTO {
    private Integer id;

    @Size(max=250,message="Tamanho do nome ácima do permitido")
    @NotBlank(message="Nome deve conter algum valor")
    private String nome;

    private String descricao;
}
