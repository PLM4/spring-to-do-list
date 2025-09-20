package br.com.pedrolucas.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrolucas.todolist.entity.Todo;
import br.com.pedrolucas.todolist.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
@Tag(name = "Todo", description = "API para gerenciamento de tarefas")
public class TodoController {
    
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @PostMapping
    @Operation(summary = "Criar uma nova tarefa")
    public List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.createTodo(todo);
    }

    @GetMapping
    @Operation(summary = "Listar todas as tarefas")
    public List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    @Operation(summary = "Atualizar uma tarefa existente")
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma tarefa pelo ID")
    public List<Todo> delete(@PathVariable("id") Long id){
        return todoService.deleteTodo(id);
    }
}
