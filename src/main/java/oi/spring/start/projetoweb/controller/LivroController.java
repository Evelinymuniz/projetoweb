package oi.spring.start.projetoweb.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import oi.spring.start.projetoweb.model.dto.LivroDTO;
import oi.spring.start.projetoweb.model.dto.MensagemDTO;
import oi.spring.start.projetoweb.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@Slf4j
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Object> listar(){
        try {
            return ResponseEntity.ok(livroService.listar());
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity <Object> pegarUm(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(livroService.pegarPorId(id));
        }catch (EntityNotFoundException ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));

        }

    }
    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody LivroDTO livroDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criar(livroDTO));
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));

        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid LivroDTO livroDTO, @PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(livroService.editar(livroDTO,id));
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable("id") Integer id){
        try{
            livroService.deletar(id);
            return ResponseEntity.ok(new MensagemDTO("Livro com id " + id + " removido com sucesso!"));
        } catch (EntityNotFoundException ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemDTO(ex.getMessage()));
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));

        }
    }
    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<Object>PegarPorCategoria(@PathVariable Integer idCategoria){
        try {
            return ResponseEntity.ok(livroService.listarPorCategoria(idCategoria));
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));
        }

    }
    @GetMapping("/editora/{idEditora}")
    public ResponseEntity<Object>PegarPorEditora(@PathVariable Integer idEditora){
        try {
            return ResponseEntity.ok(livroService.listarPorEditora(idEditora));
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(ex.getMessage()));
        }

    }
    @GetMapping("/filter")
    public ResponseEntity<Object> pegarPorNomeIbsn(
            @RequestParam(name="nome",defaultValue = "") String nome,
            @RequestParam(name="ibsn",defaultValue = "") Long ibsn)
           {
        try {
            return ResponseEntity.ok(livroService.filtrar(nome,ibsn));

        }catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }

    }




}
