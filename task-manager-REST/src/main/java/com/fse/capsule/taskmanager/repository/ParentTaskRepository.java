package com.fse.capsule.taskmanager.repository;

import com.fse.capsule.taskmanager.entity.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentTaskRepository extends JpaRepository <ParentTask,Integer>{
}
