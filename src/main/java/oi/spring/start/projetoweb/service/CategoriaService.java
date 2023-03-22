package oi.spring.start.projetoweb.service;

import jakarta.persistence.EntityNotFoundException;
import oi.spring.start.projetoweb.model.dto.CategoriaDTO;
import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import oi.spring.start.projetoweb.repository.CategoriaDBMemoria;
import oi.spring.start.projetoweb.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    private CategoriaDBMemoria repositorioDBMemoria = new CategoriaDBMemoria();
    public CategoriaDTO pegarCategoriaById(Integer id){
        Optional<CategoriaEntity> categoriaEntityOp =
                repository.findById(id);
        if(categoriaEntityOp.isPresent()){
            CategoriaEntity categoriaEntity = categoriaEntityOp.get();
            return new CategoriaDTO().update(categoriaEntity);
        }
        throw new EntityNotFoundException();
    }
    public CategoriaDTO criar(CategoriaDTO categoriaDTO){
        CategoriaEntity categoria =  new CategoriaEntity().update(categoriaDTO);
        categoria = repository.save(categoria);

        return new CategoriaDTO().update(categoria);
    }
    public CategoriaDTO editar(CategoriaDTO categoriaDTO, Integer id){
        CategoriaDTO categoriaDTOFromDB = repositorioDBMemoria.pegarUm(id);
        CategoriaDTO categoriaDTOAtualizada = categoriaDTOFromDB.update(categoriaDTO);
        return repositorioDBMemoria.editar(categoriaDTOAtualizada);
    }
    public void deletar(Integer id){
        repositorioDBMemoria.deletar(id);

    }
    public List<CategoriaDTO> getCategoriasDTOs(){
        List <CategoriaEntity> listaEntites = repository.findAll();
        return listaEntites.stream().map(categoriaEntity ->
                new CategoriaDTO().update(categoriaEntity)).toList();
    }


}
