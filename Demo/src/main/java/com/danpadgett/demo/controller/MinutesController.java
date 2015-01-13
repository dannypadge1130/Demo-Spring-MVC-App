package com.danpadgett.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danpadgett.demo.model.Activity;
import com.danpadgett.demo.model.Exercise;
import com.danpadgett.demo.model.Goal;
import com.danpadgett.demo.service.ExcerciseService;

@Controller
public class MinutesController {

	@Autowired
	private ExcerciseService excerciseService;
	
	private static final Logger logger = LoggerFactory.getLogger(MinutesController.class);

	@RequestMapping(value="/addMinutes", method=RequestMethod.GET)
	public String getMinutes(@ModelAttribute("exercise") Exercise exercise) {
		return "addMinutes";		
	}
	
	@RequestMapping(value="/addMinutes", method=RequestMethod.POST)
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise, HttpSession session, BindingResult result) {
		
		logger.info("excercise:"+exercise.getMinutes()+" activitiy:"+exercise.getActivity());
		
		if(result.hasErrors()) {
			return "addMinutes";
		} else {
			Goal goal = (Goal) session.getAttribute("goal");
			exercise.setGoal(goal);
			excerciseService.save(exercise);
		}
		
		return "addMinutes";
		
	}
	
	@RequestMapping(value="/activities", method=RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return excerciseService.findAllActivities();
	}
}
