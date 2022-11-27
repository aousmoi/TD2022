package td.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import td.ihm.option.IOption;
import td.ihm.option.OptionAjouterCompte;
import td.ihm.option.OptionCrediterCompte;
import td.ihm.option.OptionListerComptes;
import td.service.CompteService;
import td.service.UserService;

public class Menu {

	private Map<Integer, IOption> options = new HashMap();
	private Scanner scanner;
	
	public Menu(Scanner scanner , UserService userService , CompteService compteService) {
		super();
		this.scanner = scanner;
		
		options.put(1, new OptionAjouterCompte(scanner, compteService , userService));
		options.put(2, new OptionListerComptes(compteService));
		options.put(3, new OptionCrediterCompte(scanner,compteService));
		

		
	}

	public void afficher() {
		
		boolean continuer = true;

        while (continuer) {

            this.getMenuTexte();
            int choix = this.scanner.nextInt();
            this.options.get(choix).executer();
        }
		
	}
	
	private void getMenuTexte() {
		
		System.out.println("-----------------------");
		this.options.forEach((index, option) -> {
			System.out.println(index +" "+ option.getTitre());
		});
		System.out.println("-----------------------");
	}
}
