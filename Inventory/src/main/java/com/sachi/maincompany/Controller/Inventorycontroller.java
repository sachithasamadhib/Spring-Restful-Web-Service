package com.sachi.maincompany.Controller;

import com.sachi.maincompany.Dto.InventoryDTO;
import com.sachi.maincompany.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class Inventorycontroller {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getallinventory")
    public List<InventoryDTO> getallInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/getinventory/{inventoryid}")
    public InventoryDTO getinventoryid(@PathVariable int inventoryid) {
        return inventoryService.getinventoryById(inventoryid);
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

    @PostMapping("/addinventory")
    public InventoryDTO addinventory(@RequestBody InventoryDTO inventory) {
        return inventoryService.saveinventory(inventory);

    }

    @PutMapping("/updateinventory")
    public InventoryDTO updateinventory(@RequestBody InventoryDTO inventory) {
        return inventoryService.updateinventory(inventory);
    }


    @DeleteMapping("/deleteinventory/{id}")
    public String deleteinventory (@PathVariable int id) {
        return inventoryService.deleteinventory(id);
    }

}
