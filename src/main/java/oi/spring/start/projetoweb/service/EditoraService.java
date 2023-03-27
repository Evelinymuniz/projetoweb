package oi.spring.start.projetoweb.service;

import jakarta.persistence.EntityNotFoundException;
import oi.spring.start.projetoweb.model.dto.CategoriaDTO;
import oi.spring.start.projetoweb.model.dto.EditoraDTO;
import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import oi.spring.start.projetoweb.model.entity.EditoraEntity;
import oi.spring.start.projetoweb.model.mapper.EditoraMapper;
import oi.spring.start.projetoweb.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {
    private EditoraRepository repository;
    @Autowired
    private EditoraMapper mapper;

    public EditoraDTO pegarPorId(Integer id) {

        Optional<EditoraEntity> editoraEntityOptional =
                repository.findById(id);

        if(editoraEntityOptional.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOptional.get();
            return mapper.update(editoraEntity);
        }

        throw new EntityNotFoundException("Categoria não encontrada");
    }


    public EditoraDTO criar(EditoraDTO editoraDTO){
        EditoraEntity editora =  mapper.update(editoraDTO);
        editora = repository.save(editora);
        return mapper.update(editora);
    }
    public EditoraDTO editar(EditoraDTO editoraDTO, Integer id){

        if (repository.existsById(id)){
            EditoraEntity editoraEntity = mapper.update(editoraDTO);
            editoraEntity.setId(id);
            editoraEntity = repository.save(editoraEntity);

            return mapper.update(editoraEntity);
        }
        throw new EntityNotFoundException("Categoria não encontrada");
    }
    public void deletar(Integer id){
        Optional<EditoraEntity> editoraEntityOptional = repository.findById(id);

        if (editoraEntityOptional.isPresent()){
            EditoraEntity editoraEntity = editoraEntityOptional.get();
            repository.delete(editoraEntity);
            return;
        }
        throw new EntityNotFoundException("categoria não encontrada");

    }
    public List<EditoraDTO> listar(){
        List <EditoraEntity> listaEntities = repository.findAll();
        return mapper.updateListDTO(listaEntities);

    }


}



