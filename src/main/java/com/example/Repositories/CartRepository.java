package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Cart;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
