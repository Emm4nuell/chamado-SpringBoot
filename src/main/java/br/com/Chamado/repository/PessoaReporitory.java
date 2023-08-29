package br.com.Chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Chamado.domain.Pessoa;

public interface PessoaReporitory extends JpaRepository<Pessoa, Long> {

}
