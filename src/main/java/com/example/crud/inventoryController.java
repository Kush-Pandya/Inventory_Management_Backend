package com.example.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class inventoryController {
    @Autowired
    inventoryService inventoryService;

@PostMapping("/save")
public List<Inventory> save (@RequestBody Inventory item) {
    System.out.print(item);
    inventoryService.save(item);
    return findall();
    // return new ResponseEntity<String>("Recode Save",HttpStatus.ACCEPTED);
}

@GetMapping("/find/{userId}")
public ResponseEntity<Inventory> find (@PathVariable Integer userId) {
    // inventoryService.save(emp);
    Optional<Inventory> empTemp = inventoryService.find(userId);
    Inventory emp = empTemp.get();
    return new ResponseEntity<Inventory>(emp,HttpStatus.ACCEPTED);
}


// @CrossOrigin(origins = "http://localhost:3000")
@GetMapping("/findall")
public List<Inventory> findall () {
    // inventoryService.save(emp);
    List<Inventory> empTemp = inventoryService.findall();
    return empTemp;
}

@PutMapping("/update")
public ResponseEntity<String> update (@RequestBody Inventory emp) {
    inventoryService.save(emp);
    return new ResponseEntity<String>("record updated",HttpStatus.ACCEPTED);
}

@PutMapping("/updateStatus/{itemId}")
public List<Inventory> updateStatus (@PathVariable Integer itemId ,@RequestBody String Status) {
    Optional<Inventory> empTemp = inventoryService.find(itemId);
    Inventory emp = empTemp.get();
    emp.setItemStatus(Status);
    inventoryService.save(emp);
    return findall();
}

@DeleteMapping("/delete/{itemId}")
public List<Inventory> delete (@PathVariable Integer itemId) {
    inventoryService.delete(itemId);
    return findall();
}
} 