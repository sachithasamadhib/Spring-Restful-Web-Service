package com.sachi.maincompany.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor

public class Item {

    @Id
    private String id;
    private String name;
    private String Qty;
    private Double price;

}
