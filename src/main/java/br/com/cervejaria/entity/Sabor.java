package br.com.cervejaria.entity;

public enum Sabor {

	
	ADOCICADA("adocicada"),
	AMARGA("amarga"),
	FORTE("forte"),
	FRUTADA("frutada"),
	SUAVE("suave");
	
	private String descricao;
	
	Sabor(String decricao){
		this.descricao=decricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
