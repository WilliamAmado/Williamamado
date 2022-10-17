package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll() {
        return motorbikeRepository.getAll();
    }

    public Motorbike get(Integer id) {
        return motorbikeRepository.getMotorbike(id).get();
    }

    public Optional<Motorbike> getMotorbike(int id) {
        return motorbikeRepository.getMotorbike(id);
    }

    public Motorbike save(Motorbike moto) {
        if (moto.getId() == null) {
            return motorbikeRepository.save(moto);
        } else {
            Optional<Motorbike> m = motorbikeRepository.getMotorbike(moto.getId());
            if (m.isPresent()) {
                return moto;
            } else {
                return motorbikeRepository.save(moto);
            }
        }
    }

    public Motorbike update(Motorbike moto) {
        if (moto.getId() != null) {
            Optional<Motorbike> mt = motorbikeRepository.getMotorbike(moto.getId());
            if (mt.isPresent()) {
                if (moto.getName() != null) {
                    mt.get().setName(moto.getName());
                }
                if (moto.getBrand() != null) {
                    mt.get().setBrand(moto.getBrand());
                }
                if (moto.getYear() != null) {
                    mt.get().setYear(moto.getYear());
                }
                if (moto.getDescription() != null) {
                    mt.get().setDescription(moto.getDescription());
                }
                if (moto.getCategory() != null) {
                    mt.get().setCategory(moto.getCategory());
                }
                if (moto.getMessages() != null) {
                    mt.get().setMessages(moto.getMessages());
                }
                if (moto.getReservations() != null) {
                    mt.get().setReservations(moto.getReservations());
                }
                motorbikeRepository.save(mt.get());
                return mt.get();
            } else {
                return moto;
            }
        }
        return moto;

    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Motorbike> mt = motorbikeRepository.getMotorbike(id);
        if (mt.isPresent()) {
            motorbikeRepository.delete(mt.get());
            marca = true;
        }
        return marca;
    }
}
