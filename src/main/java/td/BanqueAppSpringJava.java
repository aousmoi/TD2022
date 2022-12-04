package td;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import td.config.AppConfig;
import td.ihm.Menu;

public class BanqueAppSpringJava {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Menu menu = context.getBean(Menu.class);
		menu.afficher();
		
		
	}

}
