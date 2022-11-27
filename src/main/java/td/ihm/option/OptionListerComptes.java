package td.ihm.option;

import java.util.List;

import td.model.Compte;
import td.service.CompteService;


public class OptionListerComptes implements IOption {

	CompteService compteService;
	
	
	
	
	public OptionListerComptes(CompteService compteService) {
		super();
		this.compteService = compteService;
	}
	

	@Override
	public String getTitre() {
		
		return "Liste des comptes";
	}

	@Override
	public void executer() {
		
		List<Compte> comptes =  this.compteService.getCompteList();
		for(Compte compte : comptes) {
			System.out.println(compte.getNumeroCompte()+ " | " + compte.getUser().getNom() + " | " + compte.getUser().getPrenom() 
					+ " | " + compte.getSolde() + " | " + compte.getDebitMaximale() + " | " + compte.getDecouvertMaximale() );
		}
		
	}

}
