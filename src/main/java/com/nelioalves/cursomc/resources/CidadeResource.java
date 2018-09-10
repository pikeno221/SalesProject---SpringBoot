package com.nelioalves.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.dto.CidadeDTO;
import com.nelioalves.cursomc.services.CidadeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@ApiOperation(value = "Busca Cidade")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidade(@PathVariable("id") Integer estado) {
		List<Cidade> list = service.getCidadesEstado(estado);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Busca Cidades")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<Cidade> list = service.getCidades();
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
