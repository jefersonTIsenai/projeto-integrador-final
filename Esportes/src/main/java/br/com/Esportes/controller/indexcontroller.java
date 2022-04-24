package br.com.Esportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Esportes.models.Clientes;
import br.com.Esportes.models.Produtos;
import br.com.Esportes.repository.ClientesRepository;
import br.com.Esportes.repository.ProdutoRepository;

@Controller
@RequestMapping(value = "/home")

public class indexcontroller {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Clientes> clientes = (List<Clientes>) clientesRepository.findAll();
		List<Produtos> produtos = (List<Produtos>) produtoRepository.findAll();
		modelAndView.addObject(clientes);
		modelAndView.addObject(produtos);
		return modelAndView;
	}

}
