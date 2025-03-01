package br.com.cervejaria.service;

import java.util.Optional;

import javax.naming.NameAlreadyBoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejaria.entity.EstiloCervejaEntity;
import br.com.cervejaria.exception.NameAlreadyCadastradoException;
import br.com.cervejaria.repository.EstiloCervejaDao;

@Service
@Transactional
public class EstiloService {
	
	@Autowired
	private EstiloCervejaDao dao;
	
	
	public EstiloCervejaEntity salvar(EstiloCervejaEntity estilo) throws NameAlreadyBoundException {
		Optional<EstiloCervejaEntity> estiloOptional= dao.findByNomeIgnoreCase(estilo.getNome());
		if(estiloOptional.isPresent()) {
			throw new NameAlreadyCadastradoException("O estilo já existe!");
		}
		return dao.saveAndFlush(estilo);
	}

}
