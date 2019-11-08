package br.com.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cervejaria.entity.EstiloCervejaEntity;

public interface EstiloCervejaDao extends JpaRepository<EstiloCervejaEntity, Long>{

}
