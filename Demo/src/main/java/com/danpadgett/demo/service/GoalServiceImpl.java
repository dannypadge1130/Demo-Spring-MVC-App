package com.danpadgett.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danpadgett.demo.model.Goal;
import com.danpadgett.demo.model.GoalReport;
import com.danpadgett.demo.repository.GoalRepository;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	@Transactional
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

	public List<Goal> findAllGoals() {	
		return goalRepository.findAll();
	}

	@Override
	public List<GoalReport> findAllGoalReports() {
		return goalRepository.findAllGoalReports();
	}

}
