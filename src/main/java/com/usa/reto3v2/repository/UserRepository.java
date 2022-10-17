package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Score;
import com.usa.reto3v2.entities.User;
import com.usa.reto3v2.repository.crudRepository.ScoreCrudRepository;
import com.usa.reto3v2.repository.crudRepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    public Optional<User> getUser(int idUser){
        return userCrudRepository.findById(idUser);
    }
    public User save(User s){
        return userCrudRepository.save(s);
    }
    public void delete(User s){
        userCrudRepository.delete(s);
    }
}
