package com.fse.capsule.taskmanager.service;

import com.fse.capsule.taskmanager.entity.ParentTask;
import com.fse.capsule.taskmanager.entity.Task;
import com.fse.capsule.taskmanager.repository.ParentTaskRepository;
import com.fse.capsule.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentTaskRepository parentTaskRepository;

    public List<ParentTask> getAllParentTasks(){

        List<ParentTask> parentTasks = new ArrayList<ParentTask>();
        parentTaskRepository.findAll().forEach(parentTasks::add);
        return parentTasks;
    }

    public void addParentTask(ParentTask parentTask){


        parentTaskRepository.save(parentTask);


    }
//
//    public TaskDTO getTaskById(){
//
//    }
//
//    public void updateTask(){
//
//    }
//
//    public void deleteTask(){
//
//    }


}
