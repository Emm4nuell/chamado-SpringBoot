package br.com.Chamado.domain;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa {

	private List<Chamado> chamados = new ArrayList<Chamado>();

	public Tecnico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tecnico(Long id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		// TODO Auto-generated constructor stub
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
