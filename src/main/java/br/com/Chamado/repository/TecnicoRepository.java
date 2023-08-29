package br.com.Chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Chamado.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

}
