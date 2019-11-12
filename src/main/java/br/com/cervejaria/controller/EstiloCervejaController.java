package br.com.cervejaria.controller;

import javax.naming.NameAlreadyBoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cervejaria.entity.EstiloCervejaEntity;
import br.com.cervejaria.exception.NameAlreadyCadastradoException;
import br.com.cervejaria.service.EstiloService;


@Controller
@RequestMapping("/estilo")
public class EstiloCervejaController {

	@Autowired
	private EstiloService service;

	@GetMapping("/cadastro")
	public ModelAndView cadastroEstilo(@ModelAttribute("estilo") EstiloCervejaEntity estilo) {
		ModelAndView mv = new ModelAndView("cerveja/cadastro-estilo");
		
		return mv;

	}
	
	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute("estilo") @Valid EstiloCervejaEntity estilo, BindingResult result, RedirectAttributes attr) throws NameAlreadyBoundException {
		if(result.hasErrors()) {
			return cadastroEstilo(estilo);
		}
		
		ModelAndView mv = new ModelAndView("redirect:/estilo/cadastro");
		try {
		service.salvar(estilo);
		}catch (NameAlreadyCadastradoException e) {
			result.rejectValue("nome", e.getMessage(),e.getMessage());
			return cadastroEstilo(estilo);
		}
		attr.addFlashAttribute("success", "Estilo salvo com sucesso!");
		
		return mv;
		
		
	}
	
	
	
	
	
}
