package com.sachi.maincompany.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class itemDTO {

    private String id;
    private String name;
    private String Qty;
    private Double price;
}
