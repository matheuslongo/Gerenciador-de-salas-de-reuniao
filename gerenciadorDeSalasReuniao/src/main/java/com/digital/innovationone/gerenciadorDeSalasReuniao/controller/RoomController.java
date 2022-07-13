package com.digital.innovationone.gerenciadorDeSalasReuniao.controller;


import com.digital.innovationone.gerenciadorDeSalasReuniao.exception.ResourceNotFoundException;
import com.digital.innovationone.gerenciadorDeSalasReuniao.model.Room;
import com.digital.innovationone.gerenciadorDeSalasReuniao.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createdRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @GetMapping
    public List<Room> ListAll(){
        return roomService.listAll();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable Long id) throws ResourceNotFoundException {
        return roomService.findById(id);
    }

    @PutMapping("/{id}")
    public Room updateById(@PathVariable Long id, @RequestBody Room roomToUpdate) throws ResourceNotFoundException {
        return roomService.updateRoom(id,roomToUpdate);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id) throws ResourceNotFoundException {
        roomService.delete(id);
    }







}
