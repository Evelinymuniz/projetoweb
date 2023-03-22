package oi.spring.start.projetoweb.controller;

import oi.spring.start.projetoweb.model.dto.CategoriaDTO;
import oi.spring.start.projetoweb.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private List<CategoriaDTO> lista = new ArrayList<>();
    private Integer contador = 1;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public  List<CategoriaDTO> listar(){
        return lista;
    }

    @GetMapping("/{id}")
    public CategoriaDTO pegarUm(@PathVariable("id") Integer id){
      return categoriaService.pegarCategoriaById(id);

    }


    @PostMapping
    public CategoriaDTO criar(@RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.criar(categoriaDTO);

    }

    @PutMapping("/{id}")
    public CategoriaDTO editar(@RequestBody CategoriaDTO categoriaDTO, @PathVariable("id") Integer id){
       return categoriaService.editar(categoriaDTO,id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Integer id){
        categoriaService.deletar(id);
        return "Categoria " + id + " excluida com sucesso";
    }

}
