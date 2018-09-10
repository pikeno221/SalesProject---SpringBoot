package com.nelioalves.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.dto.EstadoDTO;
import com.nelioalves.cursomc.services.EstadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;

	@ApiOperation(value = "Busca Estados")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.getEstados();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Busca Estado")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estado> find(@PathVariable Integer id) {
		Estado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
