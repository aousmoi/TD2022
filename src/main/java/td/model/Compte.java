package td.model;

import java.util.Random;

public class Compte {

	private int numeroCompte;
	private int decouvertMaximale;
	private int debitMaximale;
	private float solde;
	private User user;

	

	public Compte(int numeroCompte, float slode, int debitMaximale , int decouvertMaximale, User user) {
		super();
		this.numeroCompte = numeroCompte;
		this.decouvertMaximale = decouvertMaximale;
		this.debitMaximale = debitMaximale;
		this.solde = slode;
		this.user = user;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public int getDecouvertMaximale() {
		return decouvertMaximale;
	}

	public void setDecouvertMaximale(int decouvertMaximale) {
		this.decouvertMaximale = decouvertMaximale;
	}

	public int getDebitMaximale() {
		return debitMaximale;
	}

	public void setDebitMaximale(int debitMaximale) {
		this.debitMaximale = debitMaximale;
	}

	public float getSolde() {
		return solde;
	}

	public void setSlode(float solde) {
		this.solde = solde;
	}

}
