package com.example.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory { 
    private Integer id;
    private String Itemname;
    private String ItemStatus; 
    private Integer ItemStock;
    private String image;   
}
