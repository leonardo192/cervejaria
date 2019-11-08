package br.com.cervejaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cervejaria.entity.CervejaEntity;
import br.com.cervejaria.entity.Sabor;
import br.com.cervejaria.repository.CervejaDao;
import br.com.cervejaria.repository.EstiloCervejaDao;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {
	
	
	@Autowired
	private CervejaDao dao;
	
	@Autowired
	private EstiloCervejaDao estiloDao;
	
	@GetMapping("/estilo")
	public String cadastroEstilo(CervejaEntity cerveja) {
		return "cerveja/cadastro-estilo";
		
	}
	
	@GetMapping("/produto")
	public ModelAndView cadastroproduto(CervejaEntity cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/cadastro-produto");
		mv.addObject("estilos", estiloDao.findAll());
		return mv;
		
	}
	
	@ModelAttribute("sabor")
	public Sabor[] getSabores() {
		return Sabor.values();
	}
	


}
