package td.ihm.option;

import java.util.Scanner;

import td.model.User;
import td.service.CompteService;
import td.service.UserService;

public class OptionAjouterCompte implements IOption {

	private Scanner scanner;
	private CompteService compteService;
	private UserService userService;
	
	
	
	
	public OptionAjouterCompte(Scanner scanner, CompteService compteService , UserService userService) {
		super();
		this.scanner = scanner;
		this.compteService = compteService;
		this.userService = userService;
	}

	
	public String getTitre() {
		return "Ajouter un compte";
		
	}

	public void executer() {
		System.out.println("Saisissez le nom de l'utilisateur (sans espaces) :");
        String nom = this.scanner.next();
        
		System.out.println("Saisissez le prenom de l'utilisateur (sans espaces) :");
        String prenom = this.scanner.next();
        
		System.out.println("Saisissez le solde du compte :");
		int solde = Integer.parseInt(this.scanner.next());
        
        
		System.out.println("Saisissez le debit Maximale du compte :");
		int decouvertMaximale = Integer.parseInt(this.scanner.next());
        
        
		System.out.println("Saisissez le decouvert Maximale du compte :");
        int debitMaximale = Integer.parseInt(this.scanner.next());
        

        User user = this.userService.ajouterUser(nom, prenom);
		this.compteService.ajouterCompte(user,solde,decouvertMaximale,debitMaximale);
		
		System.out.println("Le compte initiale pour "+ nom + " " +prenom + " est cree");
		
	}

}
