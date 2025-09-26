package com.britishlibrary.British.Library.repository;

import com.britishlibrary.British.Library.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserName(String userName);
}
