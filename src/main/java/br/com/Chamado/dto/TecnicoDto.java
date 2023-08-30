package br.com.Chamado.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.Chamado.domain.Tecnico;
import br.com.Chamado.enuns.Perfil;
import lombok.Data;

@Data
public class TecnicoDto {

	protected Long id;
	@NotBlank(message = "Campo Nome é requerido")
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Integer> perfis = new HashSet<Integer>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	
	public TecnicoDto() {
		super();
		addPerfis(Perfil.CLIENTE);
	}
	
	public TecnicoDto(Tecnico tec) {
		this.id = tec.getId();
		this.nome = tec.getNome();
		this.cpf = tec.getCpf();
		this.email = tec.getEmail();
		this.senha = tec.getSenha();
		this.perfis = tec.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = tec.getDataCriacao();
		addPerfis(Perfil.CLIENTE);
	}
	
	public Tecnico toTecnico(TecnicoDto dto) {
		Tecnico tec = new Tecnico(
				null, 
				dto.getNome(), 
				dto.getCpf(), 
				dto.getEmail(), 
				dto.getSenha());
		return tec;
	}
	
	/* Vai mapear a lista de perfis no enum */
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

}
