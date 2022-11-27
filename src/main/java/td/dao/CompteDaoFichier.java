package td.dao;

import static java.util.stream.Collectors.toList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import td.model.Compte;
import td.model.User;

public class CompteDaoFichier {

	private String fichierStockage;
	private static String SEPARATOR = ";";

	public CompteDaoFichier(String fichierStockage) throws Exception {
		super();
		this.fichierStockage = fichierStockage;

		if (!Files.exists(Paths.get(this.fichierStockage))) {
			try {
				Files.createFile(Paths.get(this.fichierStockage));
			} catch (IOException e) {
				throw new Exception("Impossible de créer le fichier " + this.fichierStockage, e);
			}
		}
	}

	public void ajouterCompte(int solde, int decouvertMaximale, int debitMaximale, User user) {

		String id = String.format("%04d", new Random().nextInt(10000));
		
		FileWriter writer;
		try {
			writer = new FileWriter(this.fichierStockage , true);
			BufferedWriter buffer = new BufferedWriter(writer);

			buffer.write(id + SEPARATOR + user.getNom() + SEPARATOR + user.getPrenom() + SEPARATOR + solde + SEPARATOR + debitMaximale
					+ SEPARATOR + decouvertMaximale + "\n");

			buffer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public List<Compte> getCompteList() {
		
		try {
			
			return Files.lines(Paths.get(this.fichierStockage)).map(line -> {
				String[] strings = line.split(SEPARATOR);
				User user = new User(strings[1], strings[2]);
				
				return new Compte(Integer.parseInt(strings[0]),Integer.parseInt(strings[3]),Integer.parseInt(strings[4]),Integer.parseInt(strings[5]), user);
			}).collect(toList());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Compte getCompte(int numeroComtpe) {
		

		try {
			Path filePath = Paths.get(this.fichierStockage);
			List<String> lines = Files.readAllLines(filePath);
			
			for(String line : lines) {
				String[] strings = line.split(SEPARATOR);
				
				if(String.valueOf(numeroComtpe).equals(strings[0])) {
					User user = new User(strings[1], strings[2]);
					
					return  new Compte(Integer.parseInt(strings[0]),Integer.parseInt(strings[3]),Integer.parseInt(strings[4]),Integer.parseInt(strings[5]), user);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
