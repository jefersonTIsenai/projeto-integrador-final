package br.com.Esportes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.Esportes.models.Produtos;

@Repository
public interface ProdutoRepository extends CrudRepository<Produtos,Integer> {

}
