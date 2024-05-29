package com.test.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.TaskManager.model.Task;
import com.test.TaskManager.services.TaskServices;


@Controller
public class TaskController {

	@Autowired
	private TaskServices taskservice;

@GetMapping("/register")
public String regiAdmin(Model model) {
	
model.addAttribute("task", new Task());
	
	return "TaskRegestration";
	
}
@PostMapping("/taskstatus")
public String getadminStatus(@Validated @ModelAttribute("task") Task task,BindingResult bindResult) {
	
	taskservice.saveTask(task);
	return "redirect:/displaytask";
}

@GetMapping("/displaytask")
public String displayTask(Model model) {
	List<Task> tasks=taskservice.TaskList();
	model.addAttribute("task", tasks);
	
	
	return "task";
	
}

@GetMapping("/task/edit")
public String getEditForm(@RequestParam("id") int id,Model model) {
	Task tasks=taskservice.fintById(id);
	model.addAttribute("task", tasks);
	return "update-form";
	
}

@PostMapping("/task/delete")
public String getDelete(@RequestParam("id") int id,Model model) {
	taskservice.deleteById(id);
	return "redirect:/displaytask";
	
}
@PostMapping("/saveupdate")
public String getupdate(@Validated @ModelAttribute("task") Task task,BindingResult bindResult,Model model) {
if(bindResult.hasErrors())
{
	return "update-form";
}
taskservice.updateTask(task);
	return "redirect:/displaytask";
	
}
	
}
