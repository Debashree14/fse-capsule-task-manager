package com.fse.capsule.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.capsule.taskmanager.entity.Task;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository <Task,Integer> {


}
