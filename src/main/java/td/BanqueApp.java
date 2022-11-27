package td;

import java.util.Scanner;

import td.dao.CompteDao;
import td.dao.CompteDaoFichier;
import td.dao.UserDao;
import td.ihm.Menu;
import td.service.CompteService;
import td.service.UserService;

public class BanqueApp {

	public static void main(String[] args) {
		

		

		try {
			
			Scanner scanner = new Scanner(System.in);
			UserDao userDao = new UserDao();
			
			CompteDao compteDao = new CompteDao();
			//CompteDaoFichier compteDaoFichier = new CompteDaoFichier("stockage.txt");

			UserService userService = new UserService(userDao);
			CompteService compteService = new CompteService(compteDao);
			
			Menu menu = new Menu(scanner,userService,compteService);
			
			menu.afficher();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	}

}
