package br.com.secia.apisecia.controller;

import br.com.secia.apisecia.dto.TaskDto;
import br.com.secia.apisecia.dto.TaskDtoResponse;
import br.com.secia.apisecia.model.Task;
import br.com.secia.apisecia.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Api(value = "API Rest TASKS")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/findAll")
    @ApiOperation(value = "Listar todas as Tasks")
    @PreAuthorize("hasRole('ROLE_PAGINA_TASKS')")
    public List<TaskDtoResponse> findAll() {
        return TaskDtoResponse.convert(taskService.findAll());
    }

    @PostMapping("/save")
    @ApiOperation(value = "Gravar Task")
    @PreAuthorize("hasRole('ROLE_PAGINA_TASKS')")
    public ResponseEntity<TaskDto> save(@RequestBody TaskDto taskDto) {
        taskService.save(taskDto);
        return new ResponseEntity<TaskDto>(taskDto, HttpStatus.CREATED);
    }

}
