package ess.dao;

import java.util.List;

import ess.model.Communication;
import ess.model.Training;

public interface CommunicationDao {
	void addCommunicationDetails(Communication communication);

	List<Communication> getAllCommunicationDetails();

	void deleteCommunication(Integer id);

	Communication findByEmail(String email);

	void updateCom(Communication communication);

	Communication getComById(Integer id);
}
