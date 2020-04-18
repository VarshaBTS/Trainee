package com.cg.trainee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.trainee.bean.Trainee;
@Repository
public class TraineeDao implements TraineeIdao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Trainee> getAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m from Trainee m");
		List<Trainee> l=q.getResultList();
		return l;
	}

	@Override
	public Trainee getTraineeById(int id) {
		// TODO Auto-generated method stub
		return em.find(Trainee.class,id);
	}

	@Override
	public Trainee addTrainee(Trainee t) {
		// TODO Auto-generated method stub
		Trainee a=em.merge(t);
		return a;
	}

	@Override
	public Trainee updateTrainee(Trainee t) {
		// TODO Auto-generated method stub
		Trainee a=em.find(Trainee.class,t.getId());
		if(a!=null) {
			a.setName(t.getName());
			a.setLocation(t.getLocation());
			a.setDomain(t.getDomain());
		}
		return a;
	}

	@Override
	public Trainee deleteById(int id) {
		// TODO Auto-generated method stub
		Trainee a=em.find(Trainee.class,id);
		if(a!=null) {
			em.remove(a);
		}
		return a;
	}

}
