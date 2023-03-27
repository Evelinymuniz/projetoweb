package oi.spring.start.projetoweb.service;

import jakarta.persistence.EntityNotFoundException;
import oi.spring.start.projetoweb.model.dto.EditoraDTO;
import oi.spring.start.projetoweb.model.dto.LivroDTO;
import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import oi.spring.start.projetoweb.model.entity.EditoraEntity;
import oi.spring.start.projetoweb.model.entity.LivroEntity;
import oi.spring.start.projetoweb.model.mapper.EditoraMapper;
import oi.spring.start.projetoweb.model.mapper.LivroMapper;
import oi.spring.start.projetoweb.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private LivroMapper mapper;

    public LivroDTO pegarPorId(Integer id) {

        Optional<LivroEntity> livroEntityOptional =
                repository.findById(id);

        if(livroEntityOptional.isPresent()) {
            LivroEntity livroEntity = livroEntityOptional.get();
            return mapper.update(livroEntity);
        }

        throw new EntityNotFoundException("livro não encontrada");
    }


    public LivroDTO criar(LivroDTO livroDTO){
        LivroEntity livro =  mapper.update(livroDTO);
        livro = repository.save(livro);
        return mapper.update(livro);
    }
    public LivroDTO editar(LivroDTO livroDTO, Integer id){

        if (repository.existsById(id)){
            LivroEntity livroEntity = mapper.update(livroDTO);
            livroEntity.setId(id);
            livroEntity = repository.save(livroEntity);

            return mapper.update(livroEntity);
        }
        throw new EntityNotFoundException("Livro não encontrada");
    }
    public void deletar(Integer id){
        Optional<LivroEntity> livroEntityOptional = repository.findById(id);

        if (livroEntityOptional.isPresent()){
            LivroEntity livroEntity = livroEntityOptional.get();
            repository.delete(livroEntity);
            return;
        }
        throw new EntityNotFoundException("Livro não encontrada");

    }
    public List<LivroDTO> listar(){
        List <LivroEntity> listaEntities = repository.findAll();
        return mapper.updateListDTO(listaEntities);

    }
    public List<LivroDTO> listarPorCategoria(Integer idCategoria){
        CategoriaEntity categoria= new CategoriaEntity();
        categoria.setId(idCategoria);

        List <LivroEntity> listaEntities = repository.findByCategoria(categoria);
        return mapper.updateListDTO(listaEntities);

    }
    public List<LivroDTO> listarPorEditora(Integer idEditora){
        EditoraEntity editora = new EditoraEntity();
        editora.setId(idEditora);

        List <LivroEntity> listaEntities = repository.findByEditora(editora);
        return mapper.updateListDTO(listaEntities);

    }
    public List<LivroDTO> filtrar(String nome, Long isbn) {
        List<LivroEntity> listaEntities =  repository.findByNomeOrIsbn(nome,isbn);
        return mapper.updateListDTO(listaEntities);
    }



}
