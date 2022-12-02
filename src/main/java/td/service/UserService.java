package td.service;

import java.util.List;

import td.dao.UserDao;
import td.model.User;

public class UserService {
	
	private UserDao userDao;
	

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	public User ajouterUser(String nom , String prenom) {
		return this.userDao.ajouterUser(nom, prenom);
	}
	
	public List<User> userLists(){
		return this.userDao.getUserList();
	}
}
