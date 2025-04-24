package com.rostylka.Volleyball.repositories;

import com.rostylka.Volleyball.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
