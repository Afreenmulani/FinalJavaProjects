package com.test.TaskManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.TaskManager.Repository.TaskRepo;
import com.test.TaskManager.model.Task;
@Service
public class TaskServicesImp implements TaskServices{

	@Autowired
	private TaskRepo taskrepo;
	
	@Override
	public Task saveTask(Task task) {
		return taskrepo.save(task);
	}

	@Override
	public List<Task> TaskList() {
		List<Task> findAll= taskrepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
		taskrepo.deleteById(id);
		
	}

	@Override
	public Task fintById(int id) {
		Optional<Task> fintById=taskrepo.findById(id);
		Task task=fintById.get();
		return task;
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskrepo.save(task);
	}

}
