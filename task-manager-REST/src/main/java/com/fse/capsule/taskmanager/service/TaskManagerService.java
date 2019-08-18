package com.fse.capsule.taskmanager.service;

import com.fse.capsule.taskmanager.entity.Task;
import com.fse.capsule.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskManagerService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){

        List<Task> tasks = new ArrayList<Task>();
        //taskRepository.findAll().forEach(tasks::add);
        return  taskRepository.findAll();
        //return tasks;
    }

    public Task addUpdateTask(Task task){
        taskRepository.save(task);
        return task;
    }

       public Task getTaskById(Integer taskId){

         return taskRepository.findById(taskId).get();
  }



    public Task deleteTask(Task task){

        taskRepository.delete(task);
        return task;
   }


}
