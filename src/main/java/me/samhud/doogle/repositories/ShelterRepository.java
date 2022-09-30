package me.samhud.doogle.repositories;
import me.samhud.doogle.entities.Shelter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
}
