package br.com.cervejaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejaria.entity.CervejaEntity;


@Repository
public interface CervejaDao extends JpaRepository<CervejaEntity, Long>{
	
	public Optional<CervejaEntity>findBySku(String sku);
	
	
	public Optional<CervejaEntity> findById(Long id);
	
	

	

}
