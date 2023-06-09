package oi.spring.start.projetoweb.controller;

import oi.spring.start.projetoweb.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private List<Categoria> lista = new ArrayList<>();
    private Integer contador = 1;

    @GetMapping
    public  List<Categoria> listar(){
        return lista;
    }

    @GetMapping("/{id}")
    public Categoria pegarUm(@PathVariable("id") Integer id){
        Integer indice = null;
        for(Integer i = 0; i<lista.size();i++){
            if(lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        return lista.get(indice);
    }


    @PostMapping
    public Categoria criar(Categoria categoria){
        categoria.setId(contador);
        lista.add(categoria);
        contador++;
        return categoria;
    }

    @PutMapping("/{id}")
    public Categoria editar(@RequestBody Categoria categoria, @PathVariable("id") Integer id){
        categoria.setId(id);
        Integer indice = null;
        for(Integer i = 0; i<lista.size();i++){
            if(lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.set(indice, categoria);
        return categoria;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Integer id){

        int indice = -1;
        for(Integer i = 0; i<lista.size();i++){
            if(lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.remove(indice);
        return "Categoria excluida com sucesso";
    }

}
