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

public class Order {

    @Id
    private String id;
    private String itemid;
    private String itemname;
    private String itemprice;

}
