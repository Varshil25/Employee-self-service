package ess.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.Training;

@Repository
public class TrainingDaoImpl implements TrainingDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTraining(Training training) {
		Session session = sessionFactory.getCurrentSession();
		session.save(training);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Training> getAllTrainingDetails() {
		return sessionFactory.getCurrentSession().createQuery("from Training").list();
	}

	@Override
	public void deleteTraining(int id) {
		Training training = this.hibernateTemplate.load(Training.class, id);
		if (training != null) {
			hibernateTemplate.delete(training);
		}
	}

	@Override
	public void updateTraining(Training training) {
		hibernateTemplate.update(training);
	}

	@Override
	public Training getTrainingById(int id) {
		return this.hibernateTemplate.get(Training.class, id);
	}

}
