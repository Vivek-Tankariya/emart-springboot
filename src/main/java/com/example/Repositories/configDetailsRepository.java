package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.ConfigDetails;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface configDetailsRepository extends JpaRepository<ConfigDetails, Integer> {

}
