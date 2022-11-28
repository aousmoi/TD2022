package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import td.dao.CompteDao;
import td.dao.UserDao;
import td.exception.DebitMaximaleException;
import td.model.Compte;
import td.model.User;
import td.service.CompteService;
import td.service.UserService;

public class CompteServiceTest {

	private UserDao userDao;
	private CompteDao compteDao;
	private UserService userService;
	
	private CompteService compteService;
	
	@Before
	public void setUp() {
		this.userDao = new UserDao();
		this.compteDao = new CompteDao();
		this.userService = new UserService(userDao);
		this.compteService = new CompteService(compteDao);
	}
	
	@Test
	public void ajouterCompteTest() {
		User user = this.userService.ajouterUser("Anass", "OUSMOI");
		Compte compte = this.compteService.ajouterCompte(user, 0, 1000, 100);
		assertEquals(compte.getUser().getNom(), "Anass");
	}
	
	
	@Test
	public void crediterCompteTest() {
		
		User user = this.userService.ajouterUser("Anass", "OUSMOI");
		Compte compte = this.compteService.ajouterCompte(user, 0, 1000, 100);
		
		assertTrue(compte.getSolde() == 0);
		this.compteService.crediterCompte(compte.getNumeroCompte(), 200);
		assertTrue(compte.getSolde() == 200);
		
	}
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void debiterCompteTest_casException() {
		
		User user = this.userService.ajouterUser("Anass", "OUSMOI");
		Compte compte = this.compteService.ajouterCompte(user, 0, 1000, 100);
		
		assertTrue(compte.getSolde() == 0);
	
		thrown.expect(DebitMaximaleException.class);
		this.compteService.debiterCompte(compte.getNumeroCompte(), 1001);
	}


}
