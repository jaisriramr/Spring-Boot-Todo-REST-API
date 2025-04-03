package com.jaisriram.todorestapi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public ResponseEntity<Todo> getMethodName(@RequestParam long id) {
        Todo todo = todoService.getSingleTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Todo>> listAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @PostMapping()
    public ResponseEntity<Todo> createTodo(Todo todo) {
        Todo createdTodo = todoService.createOrUpdateTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @PutMapping()
    public ResponseEntity<Todo> UpdateTodo(Todo todo) {

        Todo updatedTodo = todoService.createOrUpdateTodo(todo);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTodo);
    }

    @DeleteMapping()
    public ResponseEntity<String> DeleteTodo(long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(new String("Todo with Id " + id + " is Deleted"));
    }

}
