package com.projeto.todolist.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.todolist.model.Task;
import com.projeto.todolist.service.TaskService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@Slf4j
public class TaskController {
    

    TaskService taskService;



    @ApiOperation(value = "Criando uma nova Tarefa")
    @ApiResponses(value = {
           @ApiResponse(code = 201 ,message = "Tarefa criada com sucesso"),
           @ApiResponse(code = 500 ,message = "Houve um erro ao criar a tarefa , verifique as informaçoes")

    })


    @PostMapping("/tasks")
    public ResponseEntity<Task>createTask(@RequestBody Task task){
        log.info("Criando uma nova  tarefa com as  informaçoes[{}]",task);
        return  ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));

        
    }


    @ApiOperation(value = "Listando todas as tarefa")
    @ApiResponses(value = {
           @ApiResponse(code = 201 ,message = "Tarefas listadas com sucesso"),
           @ApiResponse(code = 500 ,message = "Houve um erro ao listas as tarefa ")

    })
   

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task>getallTasks(){
        log.info("Listando todas as Tarefas cadastradas[{}]");
      return  taskService.listAllTasks();

    }




    @ApiOperation(value = "Buscando as Tarefa pelo id")
    @ApiResponses(value = {
           @ApiResponse(code = 201 ,message = "Tarefas encontrada com sucesso"),
           @ApiResponse(code = 500 ,message = "Nao foi encontrada nehuma tarefa pelo id ")

    })
   
    


    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task>getTaskByd(@PathVariable (value ="id")Long id){
        
        log.info("Listando Tarefas pelo Id[{}]",id);
        return taskService.findTaskById(id);
        
    }
    


    
    @ApiOperation(value = "Atualizando uma tarefa")
    @ApiResponses(value = {
           @ApiResponse(code = 201 ,message = "Tarefas Atualizada com sucesso"),
           @ApiResponse(code = 404 ,message = "Nao foi possivel atualizar a tarefa - tarefa nao encontrada ")

    })
   


     @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task>updateTaskByd(@PathVariable (value ="id")Long id,@RequestBody Task task){
        log.info("Editando Tarefas pelo Id[{}] as novas informaçoes são:[{}]",id,task);
        return taskService.updateTaskById(task,id);
        
    }
    


   
    @ApiOperation(value = "Excluindo pelo id")
    @ApiResponses(value = {
           @ApiResponse(code = 204 ,message = "Tarefas lexcluida com sucesso"),
           @ApiResponse(code = 500 ,message = "Nao foi possivel atualizar a tarefa - tarefa nao encontrada ")

    })
   
    


    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?>deleteTaskByd(@PathVariable (value ="id")Long id){
        log.info("Excluindo Tarefas pelo Id[{}]",id);
        
        return taskService.deleteByd(id);
        
    }
    




}
