package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Message get(Integer id) {
        return messageRepository.getMessage(id).get();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message mensaje) {
        if (mensaje.getIdMessage() == null) {
            return messageRepository.save(mensaje);
        } else {
            Optional<Message> m = messageRepository.getMessage(mensaje.getIdMessage());
            if (m.isPresent()) {
                return mensaje;
            } else {
                return messageRepository.save(mensaje);
            }
        }
    }

    public Message Update(Message mensaje) {
        if (mensaje.getIdMessage() != null) {
            Optional<Message> ms = messageRepository.getMessage(mensaje.getIdMessage());
            if (ms.isPresent()) {
                if (mensaje.getMessageText() != null) {
                    ms.get().setMessageText(mensaje.getMessageText());
                }
                if (mensaje.getMotorbike() != null) {
                    ms.get().setMotorbike(mensaje.getMotorbike());
                }
                if (mensaje.getClient() != null) {
                    ms.get().setClient(mensaje.getClient());
                }


                messageRepository.save(ms.get());
                return ms.get();

            } else {
                return mensaje;
            }
        } else {
            return mensaje;
        }
    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Message> m = messageRepository.getMessage(id);
        if (m.isPresent()) {
            messageRepository.delete(m.get());
            marca = true;
        }
        return marca;

    }
}
