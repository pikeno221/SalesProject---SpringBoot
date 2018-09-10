package com.nelioalves.cursomc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = estado_id ORDER BY obj.nome")
	Optional<List<Cidade>> findCidade(@Param("estadoId") Integer estado_id);

	@Query()
	Optional<List<Cidade>> findAllByOrderByNome();
}
