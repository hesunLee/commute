package com.project.commute.domain.team;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
    Teams findByName(String name);
}
