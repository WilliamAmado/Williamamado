package com.usa.reto3v2.repository.crudRepository;

import com.usa.reto3v2.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
