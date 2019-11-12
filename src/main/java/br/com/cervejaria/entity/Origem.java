package br.com.cervejaria.entity;

public enum Origem {
	
	
	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	private String nacionalidade;
	
	 Origem(String nacionalidade) {
		this.nacionalidade=nacionalidade;
		
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	 
	 
	 
	 

}
