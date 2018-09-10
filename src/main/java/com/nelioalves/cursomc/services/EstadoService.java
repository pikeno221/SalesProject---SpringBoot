package com.nelioalves.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository repo;
	public List<Estado> getEstados() {

		return repo.findAllByOrderByNome().orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado"));
		
		
	}
	public Estado find(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado"));
	}

}
