package com.fse.capsule.taskmanager;

import com.fse.capsule.taskmanager.entity.ParentTask;
import com.fse.capsule.taskmanager.entity.Task;
import com.fse.capsule.taskmanager.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TaskManagerRestApplication.class)
@ActiveProfiles(value = "test")
public class TaskManagerRestApplicationTests {

    @Value(value = "${local.server.port}")
    private Integer port;
    private String baseUrl;
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    private void contextLoads() {
    }

    @Before
    public void setUp() throws Exception {
        baseUrl = "http://localhost:".concat(port.toString()).concat("/taskmanager");
        testRestTemplate = new TestRestTemplate();

        /*Init Parent Task*/
        ParentTask parentTask = new ParentTask();
        parentTask.setParentTaskName("ParentTask1");
        parentTask.setParentTaskId(1);

        /*Init Task*/
        Task task = new Task();
        task.setTaskName("Task1");
        task.setStartDate(new Date());
        task.setEndDate(new Date());
        task.setPriority(15);
        task.setParentTaskId(parentTask.getParentTaskId());
        Task save = taskRepository.save(task);

    }

    @Test
    public void getAllTasksTest() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.toString().concat("/tasks"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllParentTasksTest() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.toString().concat("/parentTask"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }

    @Test
    public void addTaskTest() throws Exception {
        /*Init TaskDto Object*/
        Task task = new Task();
        task.setTaskName("Task2");
        task.setStartDate(new Date());
        task.setEndDate(new Date());
        task.setPriority(15);
        task.setParentTaskId(1);

        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.toString().concat("/addTask"), task, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

    @Test
    public void updateTaskTest() throws Exception {
        /*Init TaskDto Object*/
        Task task = new Task();
        task.setTaskId(2);
        task.setTaskName("Task2");
        task.setStartDate(new Date());
        task.setEndDate(new Date());
        task.setPriority(20);
        task.setParentTaskId(1);

        ResponseEntity<String> response = testRestTemplate.exchange(baseUrl.toString().concat("/updateTask"), HttpMethod.POST, new HttpEntity<>(task), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }

    @Test
    public void deleteTaskTest() throws Exception {
        /*Init TaskDto Object*/
        Task task = new Task();
        task.setTaskId(2);
        task.setTaskName("Task2");
        task.setStartDate(new Date());
        task.setEndDate(new Date());
        task.setPriority(20);
        task.setParentTaskId(1);

        ResponseEntity<String> response = testRestTemplate.exchange(baseUrl.toString().concat("/deleteTask"), HttpMethod.POST, new HttpEntity<>(task), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }
    @Test
    public void getTaskByTest() throws Exception {

        ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.toString().concat("/taskById/1"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }


    @Test
    public void addParentTaskTest() throws Exception {
        /*Init TaskDto Object*/

        ParentTask parentTask=new ParentTask();
        parentTask.setParentTaskName("ParentTask2");


        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.toString().concat("/parentTask"), parentTask, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

}