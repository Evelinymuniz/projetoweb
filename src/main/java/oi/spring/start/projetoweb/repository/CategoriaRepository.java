package oi.spring.start.projetoweb.repository;

import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends
        JpaRepository<CategoriaEntity,Integer> {

}
