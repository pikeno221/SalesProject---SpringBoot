package com.nelioalves.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repo;
	public List<Cidade> getCidades() {

		return repo.findAllByOrderByNome().orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrado"));
		
		
	}

}