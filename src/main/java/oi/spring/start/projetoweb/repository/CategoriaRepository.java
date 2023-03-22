package oi.spring.start.projetoweb.repository;

import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer> {
   // List<CategoriaEntity>findByNome(String nome); // buscar pelo nome

}
