package td.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import td.model.User;

@Component
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
