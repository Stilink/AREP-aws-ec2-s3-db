package edu.eci.arep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arep.model.Item;
import edu.eci.arep.persistence.RepositoryItem;

/**
 * SpringController
 */
@RestController
@RequestMapping(value = "/items")
public class SpringController {

    @Autowired
    private RepositoryItem rp;

    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllItems(){
        try {
            List<Item> items = (List)rp.findAll();
            return new ResponseEntity<>(items, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getItem(@PathVariable String name){
        try {
            Item item = rp.findByName(name);
            return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createItem(@RequestParam String name, @RequestParam String description){
        try {
            Item item = new Item(name, description);
            rp.save(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


}