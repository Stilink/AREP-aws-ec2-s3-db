package edu.eci.arep.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arep.model.Item;

@Repository
public interface RepositoryItem extends CrudRepository<Item, String> {
	Item findByName(String name);
}