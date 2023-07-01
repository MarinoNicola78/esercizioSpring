package com.nicolamarino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nicolamarino.model.Articolo;

@Repository
public interface IArticoloRepository extends JpaRepository<Articolo, Long> {
	
	/*Metodi Custom*/
	
	/*JPQL*/

	//SELECT
	@Query("SELECT u FROM Articolo u WHERE u.nome = :nome")
	List<Articolo> getByNomeCustom(String nome);
	
	//Query con LIKE e operatore %......% (contiene),cerca e trova tutti i valori con la keyword passata
	@Query("SELECT u FROM Articolo u WHERE u.nome like %:nome%")
	List<Articolo> getByNomeCustom1(String nome);


}
