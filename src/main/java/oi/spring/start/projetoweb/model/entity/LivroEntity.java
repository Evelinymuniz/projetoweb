package oi.spring.start.projetoweb.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Table(name="livro")
@Entity
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "editora", nullable = false)
    private EditoraEntity editora;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria", nullable = false)
    private CategoriaEntity categoria;
    @Column(name="nome", nullable = false, unique = true)
    private String nome;
    @Column(name="isbn",nullable = false)
    private Long isbn;

}
