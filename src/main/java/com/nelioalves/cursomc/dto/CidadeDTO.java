package com.nelioalves.cursomc.dto;

import com.nelioalves.cursomc.domain.Cidade;

public class CidadeDTO {
	private String nome;
	
	public CidadeDTO(Cidade obj) {
		this.nome = obj.getNome();
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
