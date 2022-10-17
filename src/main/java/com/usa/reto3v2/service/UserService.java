package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.User;
import com.usa.reto3v2.repository.ScoreRepository;
import com.usa.reto3v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public User get(Integer id) {
        return userRepository.getUser(id).get();
    }
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    public User save(User s){
        if(s.getId()==null){
            return userRepository.save(s);
        }else{
            Optional<User> r = userRepository.getUser(s.getId());
            if(r.isPresent()){
                return s;
            }else{
                return userRepository.save(s);
            }
        }
    }
    public User update(User s){
        if(s.getId()!=null){
            Optional<User> t = userRepository.getUser(s.getId());
            if(t.isPresent()){
                if(s.getName()!=null){
                    t.get().setName(s.getName());
                }

                userRepository.save(t.get());
                return t.get();
            }else{
                return s;
            }
        }else{
            return s;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<User>s= userRepository.getUser(id);
        if(s.isPresent()){
            userRepository.delete(s.get());
            flag=true;
        }
        return flag;
    }
}
