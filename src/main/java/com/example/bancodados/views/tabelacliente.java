package com.example.bancodados.views;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bancodados.RepositoryCliente.RepositoryCliente;
import com.example.bancodados.model.Cliente;

@RestController
public class tabelacliente {
	
	@Autowired
	private RepositoryCliente clisearchbancodados;

    @SuppressWarnings("unchecked")
	@GetMapping("/clientes")
	public List<Cliente> lista() {
		//Cliente cli1 = new Cliente("Phillipe Silva","pitaggph@gmail.com","(084)987121180");
		
		return clisearchbancodados.findAll();
		
		//return Arrays.asList(cli1);
	}
	    
    // Métodos de Busca
    
    @GetMapping("/clientes/{clienteid}")
    public ResponseEntity<Cliente> buscar (@Valid @PathVariable int clienteid){
    	Optional<Cliente> cliente = clisearchbancodados.findById(clienteid);
    	
    	if (cliente.isPresent()) {
    	return ResponseEntity.ok(cliente.get());
    } return ResponseEntity.notFound().build();
    
    }
    
    @GetMapping("/clientes/buscarnome/{busca}")
    public Cliente buscar_nome(@PathVariable String busca){
    Optional<Cliente> cliente = clisearchbancodados.findByNomeContaining(busca);
    return cliente.orElse(null);
    }
    
    
    // Adicionar Cliente
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
    	    	return clisearchbancodados.save(cliente);
    }
    
    
    
}
