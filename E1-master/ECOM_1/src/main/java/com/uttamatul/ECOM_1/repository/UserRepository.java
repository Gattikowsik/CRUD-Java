package com.uttamatul.ECOM_1.repository;


import com.uttamatul.ECOM_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;







@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here if needed
}
