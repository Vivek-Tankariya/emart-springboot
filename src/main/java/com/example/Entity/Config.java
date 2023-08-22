package com.example.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Config")
public class Config {
  private int ConfigID;
  private String ConfigName;
  
  private List<ConfigDetails> config_details;
	
	
	
		  @OneToMany(cascade=CascadeType.ALL)
		  @JoinColumn(name="ConfigID")
		  public List<ConfigDetails> getConfig_details() {
				return config_details;
			}
		
		  public void setConfig_details(List<ConfigDetails> config_details) {
				this.config_details = config_details;
			}
  
  

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "Config_ID")
		public int getConfigID() {
			return ConfigID;
		}
		public void setConfigID(int configID) {
			ConfigID = configID;
		}
		
		@Column(nullable = false)
		public String getConfigName() {
			return ConfigName;
		}
		public void setConfigName(String configName) {
			ConfigName = configName;
		}
		  
		  
		}
