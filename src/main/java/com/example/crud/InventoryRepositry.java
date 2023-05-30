package com.example.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.crud.Inventory;


public interface InventoryRepositry extends MongoRepository <Inventory,Integer>{
    
}
