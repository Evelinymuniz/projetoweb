package oi.spring.start.projetoweb.repository;


import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import oi.spring.start.projetoweb.model.entity.EditoraEntity;
import oi.spring.start.projetoweb.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {

    @Query("SELECT l FROM LivroEntity l" + " WHERE UPPER(l.nome) LIKE CONCAT('%', UPPER(:nome),'%' ) OR " +
            "(l.isbn) = :isbn")
    List<LivroEntity> findByNomeOrIsbn(@Param("nome") String nome, Long isbn);

    List<LivroEntity> findByCategoria(CategoriaEntity categoria);

    List<LivroEntity> findByEditora(EditoraEntity editora);




}
