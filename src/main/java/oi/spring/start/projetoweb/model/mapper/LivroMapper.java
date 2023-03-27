package oi.spring.start.projetoweb.model.mapper;

import oi.spring.start.projetoweb.model.dto.CategoriaDTO;
import oi.spring.start.projetoweb.model.dto.LivroDTO;
import oi.spring.start.projetoweb.model.entity.CategoriaEntity;
import oi.spring.start.projetoweb.model.entity.LivroEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LivroMapper {
    private CategoriaMapper categoriaMapper = new CategoriaMapper();
    private EditoraMapper editoraMapper = new EditoraMapper();
    public LivroDTO update(LivroEntity livro){

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setCategoria(categoriaMapper.update(livro.getCategoria()));
        livroDTO.setEditora(editoraMapper.update(livro.getEditora()));
        livroDTO.setIsbn(livro.getIsbn());
        return livroDTO;

    }
     public LivroEntity update(LivroDTO livro){

        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setId(livro.getId());
        livroEntity.setNome(livro.getNome());
        livroEntity.setCategoria(categoriaMapper.update(livro.getCategoria()));
        livroEntity.setEditora(editoraMapper.update(livro.getEditora()));
        livroEntity.setIsbn(livro.getIsbn());
        return livroEntity;

    }

    public List<LivroEntity> updateListEntity(List<LivroDTO> listaDTO){
        return listaDTO.stream().map(this::update).toList();
    }
    public List <LivroDTO> updateListDTO(List<LivroEntity> listaEntity){
        return listaEntity.stream().map(this::update).toList();
    }

}
