package br.com.Chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Chamado.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
