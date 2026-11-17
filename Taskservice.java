package com.klu.springmvc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.springmvc.model.Task;
import com.klu.springmvc.repository.Task_repo;

@Service
public class Taskservice {
@Autowired
Jwtservice jwts;
@Autowired
Task_repo repo;
	public Object createTask(Task task,String token) {
		Map<String,String> response=new HashMap<>();
		try {
		Map<String,String> parsedJWT=jwts.validateJWT(token);
		task.setCreatedby(Integer.parseInt(parsedJWT.get("id")));
		repo.save(task);
		response.put("message", "Task created successfully");
		}

		catch(Exception e) {
		response.put("code", "501");
		response.put("message", e.getMessage());
		}
		return response;
		}
}
