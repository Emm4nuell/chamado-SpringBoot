package br.com.Chamado.domain;

import java.time.LocalDate;

import br.com.Chamado.enuns.Prioridade;
import br.com.Chamado.enuns.Status;
import lombok.Data;

@Data
public class Chamado {

	private Long id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;

	private Cliente cliente;
	private Tecnico tecnico;

	public Chamado() {
		super();
	}

	public Chamado(Long id, Prioridade prioridade, Status status, String titulo, String observacoes, Cliente cliente,
			Tecnico tecnico) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.cliente = cliente;
		this.tecnico = tecnico;
	}

}
