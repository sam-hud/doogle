package me.samhud.doogle.repositories;
import me.samhud.doogle.entities.Dog;

import me.samhud.doogle.entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    List<Dog> findByShelter(Shelter shelter);
}