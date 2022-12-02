package td;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import td.ihm.Menu;
import td.service.CompteService;
import td.service.UserService;

public class BanqueAppSpringContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		Scanner scanner = context.getBean(Scanner.class);
		
		UserService userService = context.getBean(UserService.class);
		CompteService compteService = context.getBean(CompteService.class);
		
		Menu menu = new Menu(scanner, userService, compteService);
		menu.afficher();
		
		context.close();
		
	}

}
