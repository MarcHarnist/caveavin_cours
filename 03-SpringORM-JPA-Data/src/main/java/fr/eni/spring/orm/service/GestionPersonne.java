	package fr.eni.spring.orm.service;
	
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import fr.eni.spring.orm.bean.Personne;
	import fr.eni.spring.orm.dao.PersonneDAO;
	
	@Service(value="gestionPersonne")
	public class GestionPersonne {
	
		@Autowired
		PersonneDAO pdao;
		
		public List<Personne> listePersonnes(){
			
			return pdao.findAll();
		}
		
		public Personne rechercherPersonne(int id){
			return pdao.findOne(id);
		}
		public void ajouterPersonne(Personne p){
			pdao.save(p);
		}	
		public void modifierPersonne(Personne p){
			pdao.save(p);
		}	
		public void supprimerPersonne(Personne p){
			pdao.delete(p);
		}
		public void supprimerPersonne(int id){
			pdao.delete(id);
		}
		
		public long nombreDElements(){
			return pdao.count();
		}

		public List<Personne> rechercherPersonne(String nom){
			return pdao.findByNom(nom);
		}

		public List<Personne> rechercherPersonneNomContenant(String nom){
			return pdao.findByNomContaining(nom);
		}

		public List<Personne> rechercherPersonneNomNeContenantPas(String nom){
			return pdao.findByNomNotContaining(nom);
		}

		public List<Personne> rechercherPersonneNomCommencantOrdonneParAdresse(String nom){
			return pdao.findByNomStartingWithOrderByAdresseVilleAscAdresseCodePostalDesc(nom);
		}


		public List<Personne> rechercherPersonneParVille(String ville){
			return pdao.findByAdresseVille(ville);
		}
		/*
		List<Personne> findByNom(String nom);
		List<Personne> findByNomContaining(String nom);
		List<Personne> findByNomNotContaining(String nom);
		List<Personne> findByNomOrPrenom(String nom, String prenom);
		List<Personne> findByNomAndPrenom(String nom, String prenom);
			
		List<Personne> findByNomEndingWithOrderByAgeDesc(String nom);
		
		*/
		
		/*
		public void supprimerPersonne(String nom){
			pdao.delete(nom);
		}
		
		public Personne rechercherDernier(){
			return pdao.findLast();
		}
		*/
	}
