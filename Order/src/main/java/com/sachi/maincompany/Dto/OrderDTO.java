package com.sachi.maincompany.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String id;
    private String itemid;
    private String itemname;
    private String itemprice;

}
