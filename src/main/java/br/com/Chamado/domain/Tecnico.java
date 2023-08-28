package br.com.Chamado.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.Chamado.enuns.Perfil;

@Entity
public class Tecnico extends Pessoa {

	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<Chamado>();

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

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
