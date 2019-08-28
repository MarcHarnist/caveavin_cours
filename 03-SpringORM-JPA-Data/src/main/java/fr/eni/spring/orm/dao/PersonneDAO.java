	package fr.eni.spring.orm.dao;
	
	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.spring.orm.bean.Personne;
	
	public interface PersonneDAO extends JpaRepository<Personne, Integer>{
	
		List<Personne> findByNom(String nom);
		List<Personne> findByNomContaining(String nom);
		List<Personne> findByNomNotContaining(String nom);
		List<Personne> findByNomOrPrenom(String nom, String prenom);
		List<Personne> findByNomAndPrenom(String nom, String prenom);
			
		List<Personne> findByNomStartingWithOrderByAdresseVilleAscAdresseCodePostalDesc(String nom);
	
		
		List<Personne> findByAdresseVille(String ville);

	}

	
	