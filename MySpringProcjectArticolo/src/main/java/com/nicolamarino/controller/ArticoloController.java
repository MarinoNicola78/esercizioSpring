package com.nicolamarino.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nicolamarino.model.Articolo;
import com.nicolamarino.service.ArticoloService;

@RestController
public class ArticoloController {

	@Autowired
	ArticoloService as;

	@PostMapping("/inserarticolo")
	public void insertArticolo(@RequestBody Articolo a) {
		System.out.println("dentro: inserArticolo");
		as.insertArticolo(a);

	}

	@GetMapping("/getallarticoli")
	public ArrayList<Articolo> getAllArticoli() {
		System.out.println("dentro: getallarticoli");
		ArrayList<Articolo> articoli = as.getAllArticoli();
		return articoli;
	}

	@GetMapping("/getarticolobyid/{id}")
	public Optional<Articolo> getArticoloById(@PathVariable Long id) {
		System.out.println("dentro: getArticoloById");
		Optional<Articolo> art = as.getArticoloById(id);
		if (art.isEmpty()) {
			System.out.print("Nessun articolo trovato");
		} else if (art != null) {
			System.out.print("Risultato ricerca: \n" + art);
		}
		return art;
	}

	@GetMapping("/getarticolobynome")
	public List<Articolo> getArticoloByDescrizione(@RequestParam String nome) {
		System.out.println("dentro: getArticoloByNome");
		List<Articolo> art = as.getArticoloByNome1(nome);
		System.out.print("Articoli trovati con nome --> " + nome + "\n");
		System.out.print(art);
		return art;
	}

	@PutMapping("/updatearticolo")
	public void updateArticolo(@RequestParam Long id, @RequestParam String n, @RequestParam String p) {
		System.out.println("dentro: updateArticolo");
		Articolo art = as.updateArticolo(id, n, p);
		System.out.println(art + " : modificato con successo");
	}

	@DeleteMapping("/deletearticolo/{id}")
	public void deleteArticoloById(@PathVariable Long id) {
		System.out.println("dentro: deleteArticoloById");
		as.deleteArticoloById(id);
	}
}
