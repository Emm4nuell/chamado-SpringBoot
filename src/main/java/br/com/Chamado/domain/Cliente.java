package br.com.Chamado.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<Chamado> chamados = new ArrayList<Chamado>();

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, String nome, String cpf, String email, String senha) {
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
