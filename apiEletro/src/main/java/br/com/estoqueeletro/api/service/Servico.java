package br.com.estoqueeletro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.estoqueeletro.api.model.Aparelho;
import br.com.estoqueeletro.api.model.Mensagem;
import br.com.estoqueeletro.api.repository.RepositorioAparelho;

@Service
public class Servico {
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioAparelho acaoAparelho;
    
    public ResponseEntity<?> cadastrar(Aparelho obj) {
        if(obj.getQuantidade() <= 0){
            mensagem.setMensagem("Quantidade inválida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getPreco() <= 0){
            mensagem.setMensagem("Preço inválido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(!obj.getTipo().equals("tv") && !obj.getTipo().equals("radio") && !obj.getTipo().equals("fogao")){
            mensagem.setMensagem("Tipo de eletrodoméstico inválido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(acaoAparelho.save(obj), HttpStatus.CREATED);
        }
    }
    public ResponseEntity<?> selecionar() {
        return new ResponseEntity<>(acaoAparelho.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<?> selecionarPeloId(int id) {
        if(acaoAparelho.findById(id) == null){
            mensagem.setMensagem("Eletrodoméstico não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acaoAparelho.findById(id), HttpStatus.OK);
        }
    }
    public ResponseEntity<?> editar(Aparelho obj) {
        if(acaoAparelho.findById(obj.getId()) == null){
            mensagem.setMensagem("Eletrodoméstico não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getQuantidade() <= 0){
            mensagem.setMensagem("Quantidade inválida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getPreco() <= 0){
            mensagem.setMensagem("Preço inválido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(!obj.getTipo().equals("tv") && !obj.getTipo().equals("radio") && !obj.getTipo().equals("fogao")){
            mensagem.setMensagem("Tipo de eletrodoméstico inválido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acaoAparelho.save(obj), HttpStatus.OK);
        }
    }
    public ResponseEntity<?> remover(int id) {
        if(acaoAparelho.findById(id) == null){
            mensagem.setMensagem("Eletrodoméstico não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            acaoAparelho.deleteById(id);
            mensagem.setMensagem("Eletrodoméstico removido!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
