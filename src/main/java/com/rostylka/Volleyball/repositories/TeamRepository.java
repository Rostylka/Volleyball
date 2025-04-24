package com.rostylka.Volleyball.repositories;

import com.rostylka.Volleyball.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
