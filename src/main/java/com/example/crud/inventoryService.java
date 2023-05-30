package com.example.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class inventoryService {
    @Autowired
    private InventoryRepositry inventoryRepository;



    public Inventory save (Inventory emp) {
        return inventoryRepository.save(emp);
    }
    public Optional<Inventory> find (Integer id) {
        return inventoryRepository.findById(id);
    }

    public List<Inventory> findall () {
        return inventoryRepository.findAll();
    }

    public Inventory update (Inventory emp) {
        return inventoryRepository.save(emp);
    }
    public void delete (Integer id) {
         inventoryRepository.deleteById(id);
    }
}
