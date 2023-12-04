package br.com.estoqueeletro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoqueeletro.api.model.Aparelho;
import br.com.estoqueeletro.api.repository.RepositorioAparelho;
import br.com.estoqueeletro.api.service.Servico;

@RestController
public class Controle {

    @Autowired
    private RepositorioAparelho acaoAparelho;
    @Autowired
    private Servico servico;

    //Aparelho
    @PostMapping("/aparelho")
    public ResponseEntity<?> cadastrarAparelho(@RequestBody Aparelho obj){
        return servico.cadastrar(obj);
    }
    @GetMapping("/aparelho")
    public ResponseEntity<?> mostrarTodosAparelhos(){
        return servico.selecionar();
    }
    @GetMapping("/aparelho/{id}")
    public ResponseEntity<?> selecionarAparelhoPeloId(@PathVariable int id) {
        return servico.selecionarPeloId(id);
    }
    @GetMapping("/aparelho/estoque/{idEstoque}")
    public List<Aparelho> selecionarAparelhoPeloIdEstoque(@PathVariable int idEstoque) {
        return acaoAparelho.findByIdEstoque(idEstoque);
    }
    @PutMapping("/aparelho")
    public ResponseEntity<?> editarAparelho(@RequestBody Aparelho obj){
        return servico.editar(obj);
    }
    @DeleteMapping("/aparelho/{id}")
    public ResponseEntity<?> removerAparelho(@PathVariable int id){
        return servico.remover(id);
    }
}
