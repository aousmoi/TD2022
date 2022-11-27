package td.ihm.option;

import java.util.List;
import java.util.Scanner;

import td.model.Compte;
import td.service.CompteService;

public class OptionCrediterCompte implements IOption {

	Scanner scanner;
	CompteService compteService;

	public OptionCrediterCompte(Scanner scanner, CompteService compteService) {
		super();
		this.scanner = scanner;
		this.compteService = compteService;
	}

	@Override
	public String getTitre() {
		return "Crediter un compte";
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

			System.out.println("Choisir le compte a crediter :");
			int numeroCompte = Integer.parseInt(this.scanner.next());

			System.out.println("Choisir le montant a crediter :");
			float montant = Integer.parseInt(this.scanner.next());

			this.compteService.creditercompte(numeroCompte, montant);

			continuer = false;
		}
	}

}
