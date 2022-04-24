package br.com.Esportes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Esportes.models.Produtos;
import br.com.Esportes.repository.ProdutoRepository;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ModelAndView verTodos() {
		ModelAndView modelAndView = new ModelAndView("Produto/verTodos");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView salvar(Produtos produto) {
		repository.save(produto);
		ModelAndView modelAndView = new ModelAndView("Produto/verTodos");
		return modelAndView;
		
	}
	
	@PostMapping(value = "/deletar/{id}")
	public String deletar(@PathVariable Integer id) {
		repository.deleteById(id);
		return "redirect:/Produtos";
		
		
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView editar (@PathVariable Integer id) {
	    ModelAndView modelAndView = new ModelAndView("Produto/editar");
	    Optional<Produtos> produtos = repository.findById(id);
	    modelAndView.addObject(produtos.get());
	    return modelAndView;
	        
	}
	
	@PostMapping(value = "/editar")
	public String editarSave(Produtos produtos) {
		repository.save(produtos);
		return "redirect:/Produtos";
	}
	
	@GetMapping(value = "/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Produtos/listar");
		List<Produtos> produtos = (List<Produtos>) repository.findAll();
		modelAndView.addObject(produtos);
		return modelAndView;
	}
}
