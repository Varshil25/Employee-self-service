package ess.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User findByEmail(String email) {
		List<User> users = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email", User.class)
				.setParameter("email", email).getResultList();
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public User findByUserName(String name) {
		List<User> u = sessionFactory.getCurrentSession().createQuery("From User WHERE name = :name", User.class)
				.setParameter("name", name).getResultList();
		return u.isEmpty() ? null : u.get(0);
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void deleteUser(int id) {
		User user = this.hibernateTemplate.load(User.class, id);
		if (user != null) {
			hibernateTemplate.delete(user);
		}
	}

	@Override
	public void updateUser(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}

}
