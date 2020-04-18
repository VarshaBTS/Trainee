package com.cg.trainee.service;

import java.util.List;

import com.cg.trainee.bean.Trainee;

public interface TraineeIService {
	List<Trainee> getAll();
	Trainee getTraineeById(int id);
	Trainee addTrainee(Trainee t);
	Trainee updateTrainee(Trainee t);
	Trainee deleteById(int id);
}
