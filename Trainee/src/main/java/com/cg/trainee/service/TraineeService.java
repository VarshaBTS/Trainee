package com.cg.trainee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trainee.bean.Trainee;
import com.cg.trainee.dao.TraineeDao;
@Service
@Transactional
public class TraineeService implements TraineeIService{

	@Autowired
	TraineeDao dao;
	
	@Override
	public List<Trainee> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Trainee getTraineeById(int id) {
		// TODO Auto-generated method stub
		return dao.getTraineeById(id);
	}

	@Override
	public Trainee addTrainee(Trainee t) {
		// TODO Auto-generated method stub
		return dao.addTrainee(t);
	}

	@Override
	public Trainee updateTrainee(Trainee t) {
		// TODO Auto-generated method stub
		return dao.updateTrainee(t);
	}

	@Override
	public Trainee deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}

}
