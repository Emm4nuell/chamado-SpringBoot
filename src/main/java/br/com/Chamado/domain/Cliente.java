package br.com.Chamado.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.Chamado.dto.ClienteDto;
import br.com.Chamado.enuns.Perfil;

@Entity
public class Cliente extends Pessoa {

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamados> chamados = new ArrayList<Chamados>();

	public Cliente() {
		super();
		addPerfis(Perfil.CLIENTE);
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfis(Perfil.CLIENTE);
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(ClienteDto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfis(Perfil.CLIENTE);
	}

	public List<Chamados> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamados> chamados) {
		this.chamados = chamados;
	}

}
