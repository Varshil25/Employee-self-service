package ess.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.Communication;

@Repository
public class communicationDaoImpl implements CommunicationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addCommunicationDetails(Communication communication) {
		Session session = sessionFactory.getCurrentSession();
		session.save(communication);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Communication> getAllCommunicationDetails() {
		return sessionFactory.getCurrentSession().createQuery("from Communication").list();
	}

	@Override
	public void deleteCommunication(Integer id) {
		Communication communication = this.hibernateTemplate.load(Communication.class, id);
		if (communication != null) {
			hibernateTemplate.delete(communication);
		}

	}

	@Override
	public Communication findByEmail(String email) {
		List<Communication> communications = sessionFactory.getCurrentSession()
				.createQuery("FROM Communication WHERE email = :email", Communication.class)
				.setParameter("email", email).getResultList();
		return communications.isEmpty() ? null : communications.get(0);
	}

	@Override
	public void updateCom(Communication communication) {
		hibernateTemplate.update(communication);
	}

	@Override
	public Communication getComById(Integer id) {
		return this.hibernateTemplate.get(Communication.class, id);

	}

}
