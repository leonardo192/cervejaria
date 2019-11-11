package br.com.cervejaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejaria.entity.CervejaEntity;
import br.com.cervejaria.repository.CervejaDao;

@Service
@Transactional
public class CervejaService {
	
	@Autowired
	private CervejaDao dao;
	
	public void salvar(CervejaEntity cerveja) {
		dao.save(cerveja);
	}
	

}
