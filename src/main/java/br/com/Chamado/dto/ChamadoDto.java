package br.com.Chamado.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.Chamado.domain.Chamados;
import br.com.Chamado.enuns.Prioridade;
import br.com.Chamado.enuns.Status;
import lombok.Data;

@Data
public class ChamadoDto {

	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	private Long cliente;
	private Long tecnico;
	private String nomeTecnico;
	private String nomeCliente;
	
	public ChamadoDto() {
		super();
	}

	public ChamadoDto(Chamados obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade();
		this.status = obj.getStatus();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.cliente = obj.getCliente().getId();
		this.tecnico = obj.getTecnico().getId();
		this.nomeTecnico = obj.getTecnico().getNome();
		this.nomeCliente = obj.getCliente().getNome();
	}
	
	
	
	
}
