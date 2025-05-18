package com.sachi.maincompany.Repo;

import com.sachi.maincompany.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "Select * from user where id = ?1", nativeQuery = true)
    Product getProductbyid(int id);
}
