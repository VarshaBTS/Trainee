package com.cg.trainee.dao;

import java.util.List;

import com.cg.trainee.bean.Trainee;

public interface TraineeIdao {
	List<Trainee> getAll();
	Trainee getTraineeById(int id);
	Trainee addTrainee(Trainee t);
	Trainee updateTrainee(Trainee t);
	Trainee deleteById(int id);
}
