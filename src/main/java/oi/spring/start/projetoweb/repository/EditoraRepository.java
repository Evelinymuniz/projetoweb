package oi.spring.start.projetoweb.repository;

import oi.spring.start.projetoweb.model.entity.EditoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, Integer> {
}
