package oi.spring.start.projetoweb.repository;

import oi.spring.start.projetoweb.model.dto.EditoraDTO;

import java.util.ArrayList;
import java.util.List;

public class EditoraDBMemoria {
    private List<EditoraDTO> lista = new ArrayList<>();
    private Integer contador = 1;
    public EditoraDTO pegarUm(Integer id){
        Integer indice = null;
        for(Integer i = 0; i<lista.size();i++){
            if(lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        return lista.get(indice);
    }
    public EditoraDTO criar(EditoraDTO editoraDTO) {
        editoraDTO.setId(contador);
        lista.add(editoraDTO);
        contador++;
        return editoraDTO;
    }
    public EditoraDTO editar(EditoraDTO editoraDTO, Integer id){
        editoraDTO.setId(id);

        Integer indice = null;
        for(Integer i = 0; i<lista.size();i++){
            if(lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.set(indice, editoraDTO);
        return editoraDTO;
    }

    public EditoraDTO editar(EditoraDTO editoraDTO) {

        Integer indice = null;
        for (Integer i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(editoraDTO.getId())) {
                lista.set(i, editoraDTO);
            }else {
                throw new RuntimeException("Categoria não existente");
            }
        }
        return editoraDTO;
    }
    public void deletar(Integer id){

        int indice = -1;
        for(Integer i = 0; i<lista.size();i++){
            if(lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.remove(indice);

    }
    public List<EditoraDTO> listall() {
        return lista;
    }
}
