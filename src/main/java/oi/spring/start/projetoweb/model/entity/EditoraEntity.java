package oi.spring.start.projetoweb.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="editora")
public class EditoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome", nullable = false, unique = true,length = 100)
    private String nome;
    @Column(name="descrição")
    private String descricao;
}
