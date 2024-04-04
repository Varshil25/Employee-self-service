package ess.dao;

import java.util.List;

import org.springframework.ui.Model;

import ess.model.User;

public interface UserDao {
	User findByEmail(String email);

	User getUserById(int id);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);

	List<User> getAllUsers();
}
