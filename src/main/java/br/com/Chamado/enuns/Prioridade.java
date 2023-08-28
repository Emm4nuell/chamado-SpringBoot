package br.com.Chamado.enuns;

public enum Prioridade {

	
	BAIXO(0, "BAIXO"), MEDIO(1, "MEDIO"), ALTO(2, "ALTO");
	
	private Integer codigo;
	private String descricao;
	
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	private static Prioridade toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida!");
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
}
