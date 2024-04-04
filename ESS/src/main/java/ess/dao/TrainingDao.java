package ess.dao;

import java.util.List;

import ess.model.Training;

public interface TrainingDao {
	void addTraining(Training training);
	
	List<Training> getAllTrainingDetails();
	
	void deleteTraining(int id);
	
	void updateTraining(Training training);
	
	Training getTrainingById (int id);
}
