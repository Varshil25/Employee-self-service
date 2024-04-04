package ess.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.CommunicationDao;
import ess.model.Communication;
import ess.model.Training;

@Service
public class CommunicationService {

	@Autowired
	private CommunicationDao communicationDao;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void addCommunicationDetails(Communication communication) {
		this.hibernateTemplate.save(communication);
	}

	@Transactional
	public List<Communication> getAllCommunicationDetails() {
		return communicationDao.getAllCommunicationDetails();
	}

	@Transactional
	public void deleteCommunication(Integer id) {
		communicationDao.deleteCommunication(id);
	}

	@Transactional
	public Communication getCommunicationByEmail(String email) {
		return communicationDao.findByEmail(email);
	}

	@Transactional
	public void updateCom(Communication communication) {
		communicationDao.updateCom(communication);
	}

	@Transactional
	public Communication getComById(Integer id) {
		return communicationDao.getComById(id);
	}
}
