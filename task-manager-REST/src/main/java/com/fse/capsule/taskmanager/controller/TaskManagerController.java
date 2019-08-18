package com.fse.capsule.taskmanager.controller;


import com.fse.capsule.taskmanager.entity.ParentTask;
import com.fse.capsule.taskmanager.entity.Task;
import com.fse.capsule.taskmanager.service.ParentService;
import com.fse.capsule.taskmanager.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("taskManager")
public class TaskManagerController {

    @Autowired
    private TaskManagerService taskManagerService;
    @Autowired
    private ParentService parentService;

    @RequestMapping("/test")
    public String test(){
        return "First IntelIJSetup";
    }

    @RequestMapping("/tasks")
    public ResponseEntity<Object> getAllTasks(){

    List<Task> tasks =new ArrayList<Task>();
        tasks=taskManagerService.getAllTasks();
        Map<Object,Object> response=new HashMap<Object,Object>();
        response.put("tasks",tasks);
        response.put("List Size",tasks.size());
        response.put("Message","Success");
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value="/addTask")
    public ResponseEntity<Object>  addTask(@RequestBody Task task){
        Map<Object,Object> response=new HashMap<Object,Object>();
        if(task == null){
            response.put("Message", "Invalid Request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(task != null && task.getTaskName()==null){
            response.put("Message","Task Name cannot be empty");
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }
         else {
            Task createdTask = taskManagerService.addUpdateTask(task);

            response.put("task", createdTask);
            response.put("Message", "Successfully" + HttpStatus.CREATED);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    @RequestMapping(method = RequestMethod.POST,value="/updateTask")
    public ResponseEntity<Object> updateTask(@RequestBody Task task){
        Map<Object,Object> response=new HashMap<Object,Object>();
        if(task == null){
            response.put("Message", "Invalid Request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(task != null && task.getTaskId() == 0){
            response.put("Message","Task Id must be provided to update a task");
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }else {

            Task updatedTask = taskManagerService.addUpdateTask(task);
            response.put("task", updatedTask);
            response.put("Message", "Successfully Updated");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.GET,value="/taskById/{taskId}")
    public ResponseEntity<Object> getTaskById(@PathVariable("taskId") Integer taskId ){
        Map<Object,Object> response=new HashMap<Object,Object>();
        if(taskId == null){
            response.put("Message", "Task Id must be provided");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Task fetchedTask = taskManagerService.getTaskById(taskId);
            response.put("task", fetchedTask);
            response.put("Message", "Successfully Fetched");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.POST,value="/deleteTask")
    public ResponseEntity<Object> deleteTask(@RequestBody Task task){
        Map<Object,Object> response=new HashMap<Object,Object>();
        if(task == null){
            response.put("Message", "Invalid Request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(task != null && task.getTaskId() == 0){
            response.put("Message","Task Id must be provided to delete a task");
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }else {

            Task deletedTask = taskManagerService.deleteTask(task);
            response.put("task", deletedTask);
            response.put("Message", "Successfully Deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.POST,value="/parentTask")
    public void addParentTask(@RequestBody ParentTask parentTask){
        parentService.addParentTask(parentTask);
    }

    @RequestMapping("/parentTask")
    public List<ParentTask> getAllParentTasks(){

        List<ParentTask> tasks =new ArrayList<ParentTask>();

        return parentService.getAllParentTasks();
    }


}
