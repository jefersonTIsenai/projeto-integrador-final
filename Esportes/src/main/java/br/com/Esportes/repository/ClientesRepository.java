package br.com.Esportes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.Esportes.models.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer> {

}
