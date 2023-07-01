package com.nicolamarino.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.nicolamarino.model.Articolo;
import com.nicolamarino.repository.IArticoloRepository;

@Configuration
public class ArticoloService {

	@Autowired
	IArticoloRepository iar;

	/* CRUD */

	// Insert nuovo Articolo
	public void insertArticolo(Articolo art) {
		Articolo artSav = iar.save(art);
		System.out.println(artSav + " inserito correttamente nel DB");
	}

	// Read tutti Articoli
	public ArrayList<Articolo> getAllArticoli() {
		ArrayList<Articolo> articoli = (ArrayList<Articolo>) iar.findAll();
		System.out.println("articoli trovati nel DB: \n" + articoli);
		return articoli;
	}

	// Read Articolo by Id
	public Optional<Articolo> getArticoloById(Long id) {
		Optional<Articolo> art = iar.findById(id);
		return art;
	}

	// Read Articolo by Nome,Query Select
	public List<Articolo> getArticoloByNome1(String nome) {
		List<Articolo> art = (List<Articolo>) iar.getByNomeCustom1(nome);
		return art;
	}

	// Update Articolo
	public Articolo updateArticolo(Long id, String n, String p) {
		Optional<Articolo> art = iar.findById(id);
		art.get().setNome(n);
		art.get().setPrezzo(p);
		return iar.save(art.get());
	}

	// Delete Articolo by Id
	public void deleteArticoloById(Long id) {
		Optional<Articolo> art = iar.findById(id);
		iar.delete(art.get());
	}
}
