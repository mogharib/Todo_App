package com.MoAbdelHamied.TodoApp.Security;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <AppUser , String> {
}
