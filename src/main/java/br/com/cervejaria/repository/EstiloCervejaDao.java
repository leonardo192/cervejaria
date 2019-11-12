package br.com.cervejaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejaria.entity.EstiloCervejaEntity;

@Repository
public interface EstiloCervejaDao extends JpaRepository<EstiloCervejaEntity, Long>{
	
	public Optional<EstiloCervejaEntity> findByNomeIgnoreCase(String nome);

}
