package com.sachi.maincompany.Repo;

import com.sachi.maincompany.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "Select * from user where id = ?1", nativeQuery = true)
    User getuserbyid(int id);
}
