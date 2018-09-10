package com.nelioalves.cursomc.dto;

import com.nelioalves.cursomc.domain.Cidade;

public class CidadeDTO {
	private int id;
	private String nome;
	
	public CidadeDTO(Cidade obj) {
		this.nome = obj.getNome();
		this.setId(obj.getId());
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
