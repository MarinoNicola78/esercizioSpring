package com.nicolamarino.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articoli")
public class Articolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome, prezzo;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public Articolo() {
	}
		
	
	public Articolo(String nome, String prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Articolo [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + "] \n";
	}
	
	
	
	

}
