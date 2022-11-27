package td.ihm.option;

import java.util.List;
import java.util.Scanner;

import td.model.Compte;
import td.service.CompteService;

public class OptionDebiterCompte implements IOption {

	
	Scanner scanner;
	CompteService compteService;
	
	
	public OptionDebiterCompte(Scanner scanner, CompteService compteService) {
		super();
		this.scanner = scanner;
		this.compteService = compteService;
	}
	
	

	@Override
	public String getTitre() {
		return "Debiter un Compte";
	}

	@Override
	public void executer() {
		
		boolean continuer = true;

		while (continuer) {
			
			List<Compte> compteList = this.compteService.getCompteList();
			for (Compte compte : compteList) {
				System.out.println(compte.getNumeroCompte() + " | " + compte.getUser().getNom() + " | "
						+ compte.getUser().getPrenom() + " | " + compte.getSolde() + " | " + compte.getDebitMaximale()
						+ " | " + compte.getDecouvertMaximale());
			}

			System.out.println("Choisir le compte a debiter :");
			int numeroCompte = Integer.parseInt(this.scanner.next());

			System.out.println("Choisir le montant a debiter :");
			float montant = Integer.parseInt(this.scanner.next());

			this.compteService.debiterCompte(numeroCompte, montant);

			continuer = false;
			
			
		}
		
	}

}
