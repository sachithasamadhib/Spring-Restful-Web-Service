package com.sachi.maincompany.Service;

import com.sachi.maincompany.Dto.InventoryDTO;
import com.sachi.maincompany.Model.Inventory;
import com.sachi.maincompany.Repo.InventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<InventoryDTO> getAllInventory(){
        List<Inventory> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList, new TypeToken<List<InventoryDTO>>() {}.getType());
    }

    public InventoryDTO saveinventory(InventoryDTO inventory) {
        inventoryRepo.save(modelMapper.map(inventory, Inventory.class));
        return inventory;
    }

    public InventoryDTO updateinventory(InventoryDTO inventory) {
        inventoryRepo.save(modelMapper.map(inventory, Inventory.class));
        return inventory;
    }

    public String deleteinventory(int id){
        try {
            if(inventoryRepo.existsById(id)){
                inventoryRepo.deleteById(id);
                return "Deleted Successfully";
            } else {
                return "Inventory with ID " + id + " not found";
            }
        } catch (Exception e) {
            return "Error deleting inventory: " + e.getMessage();
        }
    }
    public InventoryDTO getinventoryById(int id) {
        Inventory inventory = inventoryRepo.getInventoryById(id);
        return modelMapper.map(inventory,InventoryDTO.class);
    }

}