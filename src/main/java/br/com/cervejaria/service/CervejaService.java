package br.com.cervejaria.service;

import java.util.Optional;

import javax.naming.NameAlreadyBoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejaria.entity.CervejaEntity;
import br.com.cervejaria.exception.NameAlreadyCervejaCadastradaException;
import br.com.cervejaria.repository.CervejaDao;

@Service
@Transactional
public class CervejaService {
	
	@Autowired
	private CervejaDao dao;
	
	public void salvar(CervejaEntity cerveja) {
		Optional<CervejaEntity> cervejaOprional = dao.findByNomeIgnoreCase(cerveja.getNome());
		if(cervejaOprional.isPresent()) {
			throw new NameAlreadyCervejaCadastradaException("Cerveja ja existe no sistema!");
		}
		dao.save(cerveja);
	}
	

}
