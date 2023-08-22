package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Entity.Config;
import com.example.Services.ConfigService;

@RestController
@CrossOrigin
@RequestMapping("/api/Config")
public class ConfigController 
{
	@Autowired
	private ConfigService configService;
	
	@GetMapping
	public ResponseEntity<?> getAllConfigs(){
		return new ResponseEntity<> (configService.getAllConfigs(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{ConfigId}")
	public ResponseEntity<?> getConfigId(@PathVariable int ConfigId) {
		return new ResponseEntity<> (configService.getConfigById(ConfigId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addConfig(@RequestBody Config Config) {
		return new ResponseEntity<> (configService.addConfig(Config),HttpStatus.CREATED);
	}
	
	@PutMapping("/{ConfigId}")
	public ResponseEntity<?> updateConfig(@PathVariable int ConfigId,@RequestBody Config updatedConfig) {
		return new ResponseEntity<> (configService.updateConfig(ConfigId,updatedConfig),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{ConfigId}")
      public void deleteConfig(@PathVariable int ConfigId) {
    	  configService.deleteConfig(ConfigId);
      }
	

}
