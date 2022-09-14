package com.MoAbdelHamied.TodoApp.Controller;

import com.MoAbdelHamied.TodoApp.Model.Todos;
import com.MoAbdelHamied.TodoApp.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("api/v1/todos")


public class TodoController {
@Autowired
TodoService todoService;



    @GetMapping({"" ,"/"})
    public ResponseEntity <List<Todos>> getAllTodos (){
        List <Todos> result = todoService.findAll();
        return  new ResponseEntity<>(result , HttpStatus.OK);    }


    @GetMapping("/{id}")
    public ResponseEntity <Todos> getTodoById (@PathVariable String id)
    {
        Todos result = todoService.findById(id);
        return  new ResponseEntity<>(result , HttpStatus.OK);    }

    @PostMapping({"" ,"/"})
    public ResponseEntity <Todos>  createNewTodo ( @Validated @RequestBody Todos todos)
    {
        Todos result = todoService.save(todos);
        return  new ResponseEntity<>(result , HttpStatus.CREATED);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void>  deleteTodo (@PathVariable String id)
    {
        todoService.deleteOneTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity <Todos> updateTodos (@RequestBody Todos todos , @PathVariable String id  )
    {
        Todos result = todoService.putTodos(todos ,id );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}


