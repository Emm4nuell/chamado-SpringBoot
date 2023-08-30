package br.com.Chamado.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.Chamado.enuns.Perfil;

@Entity
public class Tecnico extends Pessoa {

	/*Ignora o campo na hora de chamar*/
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Chamados> chamados = new ArrayList<Chamados>();

	public Tecnico() {
		super();
		addPerfis(Perfil.CLIENTE);
		// TODO Auto-generated constructor stub
	}

	public Tecnico(Long id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfis(Perfil.CLIENTE);
		// TODO Auto-generated constructor stub
	}

	public List<Chamados> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamados> chamados) {
		this.chamados = chamados;
	}

}
