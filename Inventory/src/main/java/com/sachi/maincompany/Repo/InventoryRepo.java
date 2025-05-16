package com.sachi.maincompany.Repo;

import com.sachi.maincompany.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    @Query(value = "Select * from Inventory where id = ?1", nativeQuery = true)
    Inventory getInventoryById(int id);
}
