package com.example.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Config;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface ConfigRepository extends JpaRepository<Config, Integer> 
{
	
}
