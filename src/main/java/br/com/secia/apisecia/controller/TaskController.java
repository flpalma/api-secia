package br.com.secia.apisecia.controller;

import br.com.secia.apisecia.model.Task;
import br.com.secia.apisecia.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
@Api(value = "API Rest TASKS")
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/findAll")
    @ResponseBody
    @ApiOperation(value = "Listar todas as Tasks")
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @PostMapping("/save")
    @ResponseBody
    @ApiOperation(value = "Gravar Task")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        taskService.save(task);
        return new ResponseEntity<Task>(task, HttpStatus.CREATED);
    }

}
