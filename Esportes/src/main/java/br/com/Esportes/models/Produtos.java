package br.com.Esportes.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produtos {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private double preco;

	private String marca;

	private LocalDateTime datacriacao = LocalDateTime.now();

	public Produtos() {
		super();
	}

	public Produtos(String nome, double preco, String marca) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}

}