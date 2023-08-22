package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Config_details")
public class ConfigDetails {
	
	private int Config_detailsID;
	private int ConfigID;
	private String Config_details;
	private int ProdID;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Config_detailsID")
	public int getConfig_detailsID() {
		return Config_detailsID;
	}
	
	public void setConfig_detailsID(int config_detailsID) {
		Config_detailsID = config_detailsID;
	}
	
	@Column(nullable = false)
	public int getConfigID() {
		return ConfigID;
	}
	public void setConfigID(int configID) {
		ConfigID = configID;
	}
	
	@Column(nullable = false)
	public String getConfig_details() {
		return Config_details;
	}
	public void setConfig_details(String config_details) {
		Config_details = config_details;
	}
	
	@Column(nullable = false)
	public int getProdID() {
		return ProdID;
	}
	public void setProdID(int prodID) {
		ProdID = prodID;
	}
	
}
