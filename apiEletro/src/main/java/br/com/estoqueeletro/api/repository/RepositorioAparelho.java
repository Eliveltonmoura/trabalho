package br.com.estoqueeletro.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.estoqueeletro.api.model.Aparelho;

@Repository
public interface RepositorioAparelho extends CrudRepository<Aparelho, Integer>{
    
    List<Aparelho> findAll();
    
    Aparelho findById(int id);
    
    @Query(value = "SELECT * FROM Eletrodomesticos WHERE idEstoque = :idEstoque", nativeQuery = true)
    List<Aparelho> findByIdEstoque(int idEstoque);
}
