package br.com.Chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Chamado.domain.Chamados;

public interface ChamadoRepository extends JpaRepository<Chamados, Long> {

}
