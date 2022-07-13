package com.digital.innovationone.gerenciadorDeSalasReuniao.service;

import com.digital.innovationone.gerenciadorDeSalasReuniao.exception.ResourceNotFoundException;
import com.digital.innovationone.gerenciadorDeSalasReuniao.model.Room;
import com.digital.innovationone.gerenciadorDeSalasReuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    public RoomRepository roomRepository;

    public Room verifyExist(Long id) throws ResourceNotFoundException {
        Room roomExist= roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room with id: "+id+" not exist."));
        return roomExist;
    }

    public List<Room> listAll(){
        return roomRepository.findAll();
    }

    public Room findById(Long id) throws ResourceNotFoundException {
        return verifyExist(id);
    }

    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id,Room room) throws ResourceNotFoundException {
        Room roomToExist =verifyExist(id);
        Room roomToUpdate=room.builder().id(id).name(roomToExist.getName()).date(roomToExist.getDate()).startHour(roomToExist.getStartHour()).endHour(roomToExist.getEndHour()).build();
        return roomRepository.save(roomToUpdate);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        verifyExist(id);
        roomRepository.deleteById(id);
    }



}
