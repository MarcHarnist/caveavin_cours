package fr.eni.spring.orm.main;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import fr.eni.spring.orm.bean.Adresse;
import fr.eni.spring.orm.bean.Personne;
import fr.eni.spring.orm.service.GestionPersonne;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		GestionPersonne gp = context.getBean("gestionPersonne", GestionPersonne.class);
		
		List<Personne> liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}	
		
		Personne p1 = new Personne("Lebrun", "Luc", new Adresse("75018", "Paris"));
		gp.ajouterPersonne(p1);
		
		System.out.println("Liste des personnes apres ajout");
		liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}	
		
		p1.setPrenom("Lucie");
		gp.modifierPersonne(p1);
		
		System.out.println("Liste des personnes apres modification");
		liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}	
		
		gp.supprimerPersonne(p1);
		
		System.out.println("Liste des personnes apres suppression");
		liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}	
		
		System.out.println("Nombre d'éléments : " + gp.nombreDElements());
		
		
		System.out.println("\nListe des personnes dont le nom est 'Lemoyen'");
		liste = gp.rechercherPersonne("Lemoyen");
		for (Personne personne : liste) {
			System.out.println(personne);
		}	
		
		System.out.println("\nListe des personnes dont le nom contient 'gr'");
		liste = gp.rechercherPersonneNomContenant("gr");
		for (Personne personne : liste) {
			System.out.println(personne);
		}	

		System.out.println("\nListe des personnes dont le nom ne contient pas 'gr'");
		liste = gp.rechercherPersonneNomNeContenantPas("gr");
		for (Personne personne : liste) {
			System.out.println(personne);
		}	


		System.out.println("\nListe des personnes dont le nom ne commence par 'le' et ordonné");
		liste = gp.rechercherPersonneNomCommencantOrdonneParAdresse("Le");
		for (Personne personne : liste) {
			System.out.println(personne);
		}	

		System.out.println("\nListe des parisiens");
		liste = gp.rechercherPersonneParVille("Paris");
		for (Personne personne : liste) {
			System.out.println(personne);
		}	
		
		Personne p11 = new Personne("Legrand", "Anne", new Adresse("44100", "Nantes"));
		Personne p2 = new Personne("Lemoyen", "Jules", new Adresse("33000", "Bordeaux"));
		Personne p3 = new Personne("Lepetit", "Suzie", new Adresse("75010", "Paris"));
		Personne p4 = new Personne("LeBlond", "Marc", new Adresse("75002", "Paris"));

		gp.ajouterPersonne(p11);
		gp.ajouterPersonne(p2);
		gp.ajouterPersonne(p3);
		gp.ajouterPersonne(p4);
	
		context.close();
	}

}
