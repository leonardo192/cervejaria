package br.com.cervejaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejaria.entity.EstiloCervejaEntity;
import br.com.cervejaria.repository.EstiloCervejaDao;

@Service
@Transactional
public class EstiloService {
	
	@Autowired
	private EstiloCervejaDao dao;
	
	
	public void salvar(EstiloCervejaEntity estilo) {
		dao.save(estilo);
	}

}
