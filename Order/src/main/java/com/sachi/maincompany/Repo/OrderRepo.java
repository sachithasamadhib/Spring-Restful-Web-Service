package com.sachi.maincompany.Repo;

import com.sachi.maincompany.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "Select * from Order where id = ?1", nativeQuery = true)
    Order getOrderbyid(int id);
}
