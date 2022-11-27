package td.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import td.model.Compte;
import td.model.User;

public class CompteDao {
	
	List<Compte> compteList = new ArrayList<Compte>();
	
	
	public List<Compte> getCompteList() {
		return compteList;
	}


	public void ajouterCompte( int solde, int decouvertMaximale, int debitMaximale, User user) {
		String id = String.format("%04d", new Random().nextInt(10000));
		Compte compte = new Compte(Integer.parseInt(id),solde, decouvertMaximale, debitMaximale, user);
		this.compteList.add(compte);
	}
	
	
	public Compte getCompte(int numeroCompte) {
		
		for(Compte compte : this.compteList) {
			if(numeroCompte == compte.getNumeroCompte()) {
				return compte;
			}
		}
		return null;
	}
	
	public void crediterCompte(int numeroCompte , float montant ) {
		
		for(Compte compte : this.compteList) {
			if(numeroCompte == compte.getNumeroCompte()) {
				
				int index = this.compteList.indexOf(compte);
				compte.setSlode(compte.getSolde() + montant);
				
				this.compteList.set(index, compte);
			}
		}
	}

}
