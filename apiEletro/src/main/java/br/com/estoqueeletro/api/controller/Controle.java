package br.com.estoqueeletro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoqueeletro.api.model.Aparelho;
import br.com.estoqueeletro.api.repository.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @PostMapping("/estoque")
    public Aparelho cadastrar(@RequestBody Aparelho obj){
        return acao.save(obj);
    }

    @GetMapping("/estoque")
    public List<Aparelho> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/estoque/{id}")
    public Aparelho selecionarPeloCodigo(@PathVariable int id) {
        return acao.findById(id);
    }

    @PutMapping("/estoque")
    public Aparelho editar(@RequestBody Aparelho obj){
        return acao.save(obj);
    }

    @DeleteMapping("/estoque/{id}")
    public void remover(@PathVariable int id){
        acao.deleteById(id);
    }
}
