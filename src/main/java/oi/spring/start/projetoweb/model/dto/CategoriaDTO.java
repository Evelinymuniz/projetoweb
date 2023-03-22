package oi.spring.start.projetoweb.model.dto;

import lombok.Getter;
import lombok.Setter;
import oi.spring.start.projetoweb.model.entity.CategoriaEntity;

@Getter
@Setter
public class CategoriaDTO {
    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO update(CategoriaEntity categoriaDTO){
        this.id = categoriaDTO.getId();
        this.nome = categoriaDTO.getNome();
        this.descricao = categoriaDTO.getDescricao();
        return this;
    }
}
