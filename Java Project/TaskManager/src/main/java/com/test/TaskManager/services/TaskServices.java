package com.test.TaskManager.services;

import java.util.List;

import com.test.TaskManager.model.Task;


public interface TaskServices {
	
	public Task saveTask(Task task);
	public List<Task> TaskList();
	public void deleteById(int id);
	public Task fintById(int id);
	public Task updateTask(Task task);
	
	
	

}
