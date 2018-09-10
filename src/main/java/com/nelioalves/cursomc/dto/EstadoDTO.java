package com.nelioalves.cursomc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	private List<CidadeDTO> cidades = new ArrayList<>();

	public EstadoDTO(Estado obj) {
		this.nome = obj.getNome();
		if (obj.getCidades() != null) {
			for (Cidade cidade : obj.getCidades()) {
				CidadeDTO cidadeAux = new CidadeDTO(cidade);
				this.cidades.add(cidadeAux);
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CidadeDTO> getCidades() {
		return cidades;
	}

	public void setCidades(List<CidadeDTO> cidades) {
		this.cidades = cidades;
	}

}
