package com.example.bancodados.RepositoryCliente;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bancodados.model.Cliente;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente, Integer> {
	Optional<Cliente> findByNomeContaining(String Nome);
	Optional<Cliente> findByNome(String Nome);

}
