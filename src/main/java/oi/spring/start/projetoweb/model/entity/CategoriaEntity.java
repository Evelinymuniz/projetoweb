package oi.spring.start.projetoweb.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome", nullable = false, unique = true)
    private String nome;
    @Column(name="descrição")
    private String descricao;



}
