package ess.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.UserDao;
import ess.model.Training;
import ess.model.User;

@Service
public class UserService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private UserDao userDao;

	@Transactional
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	@Transactional
	public User findByUserName(String name) {
		return userDao.findByUserName(name);
	}

	public boolean validatePassword(User user, String password) {
		return user.getPassword().equals(password);
	}

	@Transactional
	public void addUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Transactional
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

}
