package td.dao;

import java.util.ArrayList;
import java.util.List;

import td.model.User;

public class UserDao {

	List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}

	public User ajouterUser(String nom, String prenom) {

		User user = new User(nom, prenom);
		this.userList.add(user);

		return user;

	}
}
