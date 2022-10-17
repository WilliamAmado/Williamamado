package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepositor;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepositor.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepositor.findById(id);
    }

    public Message save(Message mensaje) {
        return messageCrudRepositor.save(mensaje);
    }

    public void delete(Message mensaje) {
        messageCrudRepositor.delete(mensaje);
    }
}
