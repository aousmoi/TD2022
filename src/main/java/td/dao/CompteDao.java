package td.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import td.exception.DebitMaximaleException;
import td.model.Compte;
import td.model.User;

public class CompteDao {

	List<Compte> compteList = new ArrayList<Compte>();

	public List<Compte> getCompteList() {
		return compteList;
	}

	public Compte ajouterCompte(int solde, int debitMaximale, int decouvertMaximale, User user) {
		String id = String.format("%04d", new Random().nextInt(10000));
		Compte compte = new Compte(Integer.parseInt(id), solde, debitMaximale, decouvertMaximale, user);
		this.compteList.add(compte);
		return compte;
	}

	public Compte getCompte(int numeroCompte) {

		for (Compte compte : this.compteList) {
			if (numeroCompte == compte.getNumeroCompte()) {
				return compte;
			}
		}
		return null;
	}

	public void crediterCompte(int numeroCompte, float montant) {

		for (Compte compte : this.compteList) {
			if (numeroCompte == compte.getNumeroCompte()) {

				int index = this.compteList.indexOf(compte);

				float nouveauMontant = compte.getSolde() + montant;
				compte.setSlode(nouveauMontant);

				this.compteList.set(index, compte);
			}
		}
	}

	public void debiterCompte(int numeroCompte, float montant) {

		for (Compte compte : this.compteList) {
			if (numeroCompte == compte.getNumeroCompte()) {

				int index = this.compteList.indexOf(compte);

				if (montant > compte.getDebitMaximale()) {
					throw new DebitMaximaleException();
				}

				float nouveauMontant = compte.getSolde() - montant;
				compte.setSlode(nouveauMontant);

				this.compteList.set(index, compte);
			}
		}
	}

}
