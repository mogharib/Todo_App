package com.MoAbdelHamied.TodoApp.Repository;

import com.MoAbdelHamied.TodoApp.Model.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository <Todos ,String> {
    Todos findByTitle(String title);
}
