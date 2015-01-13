package com.danpadgett.demo.service;

import java.util.List;

import com.danpadgett.demo.model.Goal;
import com.danpadgett.demo.model.GoalReport;

public interface GoalService {

	Goal save(Goal goal);
	List<Goal> findAllGoals();
	List<GoalReport> findAllGoalReports();
	
}
