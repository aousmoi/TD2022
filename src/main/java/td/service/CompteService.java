package td.service;

import java.util.List;

import td.dao.CompteDao;
import td.dao.CompteDaoFichier;
import td.model.Compte;
import td.model.User;

public class CompteService {

	private CompteDao compteDao;
	//private CompteDaoFichier compteDao;

	public CompteService(CompteDao compteDao) {
		super();
		this.compteDao = compteDao;
	}

	public Compte ajouterCompte(User user, int solde, int debitMax , int decouvertMax) {
		return this.compteDao.ajouterCompte(solde, debitMax, decouvertMax, user);
	}

	public List<Compte> getCompteList() {
		return this.compteDao.getCompteList();
	}
	
	
	public Compte getCompte(int numeroCompte) {
		return this.compteDao.getCompte(numeroCompte);
	}
	
	public void crediterCompte(int numeroCompte , float montant) {
		this.compteDao.crediterCompte(numeroCompte, montant);
	}
	
	
	public void debiterCompte(int numeroCompte , float montant) {
		this.compteDao.debiterCompte(numeroCompte, montant);
	}
	
}
