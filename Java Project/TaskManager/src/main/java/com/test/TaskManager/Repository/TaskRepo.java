package com.test.TaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.TaskManager.model.Task;

@Repository
public interface TaskRepo  extends JpaRepository<Task ,Integer>{

}
