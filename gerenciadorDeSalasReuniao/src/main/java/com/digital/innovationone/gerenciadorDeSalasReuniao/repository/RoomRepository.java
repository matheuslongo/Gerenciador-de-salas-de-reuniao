package com.digital.innovationone.gerenciadorDeSalasReuniao.repository;

import com.digital.innovationone.gerenciadorDeSalasReuniao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
