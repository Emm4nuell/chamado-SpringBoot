package br.com.Chamado.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.Chamado.enuns.Perfil;

@Entity
public class Cliente extends Pessoa {

	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<Chamado>();

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

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
