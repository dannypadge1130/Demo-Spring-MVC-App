package com.danpadgett.demo.service;

import java.util.List;

import com.danpadgett.demo.model.Activity;
import com.danpadgett.demo.model.Exercise;

public interface ExcerciseService {

	List<Activity> findAllActivities();
	Exercise save(Exercise exercise);
}