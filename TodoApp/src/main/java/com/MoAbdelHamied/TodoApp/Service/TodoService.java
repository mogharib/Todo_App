package com.MoAbdelHamied.TodoApp.Service;


import com.MoAbdelHamied.TodoApp.Exceptions.ConflictException;
import com.MoAbdelHamied.TodoApp.Exceptions.NotFoundException;
import com.MoAbdelHamied.TodoApp.Model.Todos;
import com.MoAbdelHamied.TodoApp.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
  @Autowired
   private TodoRepository todoRepository;

    public List<Todos> findAll()
    {
        return todoRepository.findAll();
    }

    public Todos findById(String id) {
        try {
          return   todoRepository.findById(id).get();
        } catch (NoSuchElementException exception)  {

            throw new NotFoundException(String.format("this id [%s] is not found in database" , id ));
        }

    }
    public Todos save(Todos todos) {
        if (todoRepository.findByTitle(todos.getTitle()) != null) {
            throw new ConflictException("this title is already taken");
        }
        return todoRepository.insert(todos);
    }

    public void deleteOneTodo(String id) {
         todoRepository.deleteById(id);
    }

    public Todos putTodos(Todos todos , String id) {
        try {
            Todos todosDb = todoRepository.findById(id).get();
            if (Objects.nonNull(todos.getTitle())
                    && !"".equalsIgnoreCase(
                    todos.getTitle())) {
                todosDb.setTitle(
                        todos.getTitle());
            }

            if (Objects.nonNull(todos.getDescription())
                    && !"".equalsIgnoreCase(
                    todos.getDescription())) {
                todosDb.setDescription(
                        todos.getDescription());
            }
            return todoRepository.save(todosDb);
        }
        catch (NoSuchElementException exception){
            throw new NotFoundException(String.format("this id [%s] is not found in database , id "));

        }

    }

}
