package oi.spring.start.projetoweb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import oi.spring.start.projetoweb.model.dto.CategoriaDTO;

@Getter
@Setter
@Entity
@Table(name="categoria")
public class CategoriaEntity {
    @Id
    private Integer id;
    @Column(name="nome", nullable = false, unique = true)
    private String nome;
    @Column(name="descrição")
    private String descricao;

    public CategoriaEntity update(CategoriaDTO categoria){
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        return this;
    }

}
