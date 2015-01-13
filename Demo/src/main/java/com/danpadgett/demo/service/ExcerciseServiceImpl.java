package com.danpadgett.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danpadgett.demo.model.Activity;
import com.danpadgett.demo.model.Exercise;
import com.danpadgett.demo.repository.ExerciseRepository;

@Service("excerciseService")
public class ExcerciseServiceImpl implements ExcerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDescription("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDescription("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDescription("Swim");
		activities.add(swim);
		
		return activities;
		
	}

	@Transactional
	public Exercise save(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}
	
}
