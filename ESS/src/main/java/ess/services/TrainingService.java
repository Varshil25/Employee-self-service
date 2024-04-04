package ess.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.TrainingDao;
import ess.dao.UserDao;
import ess.model.Training;
import ess.model.User;

@Service
public class TrainingService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private TrainingDao trainingDao;

	@Transactional
	public void addTraining(Training training) {
		this.hibernateTemplate.saveOrUpdate(training);

	}

	@Transactional
	public List<Training> getAllTrainingDetails() {
		return trainingDao.getAllTrainingDetails();
	}

	@Transactional
	public void deleteTraining(int id) {
		trainingDao.deleteTraining(id);
	}

	public void updateTraining(Training training) {
		trainingDao.updateTraining(training);
	}

	public Training getTrainingById(int id) {
		return trainingDao.getTrainingById(id);
	}
}
