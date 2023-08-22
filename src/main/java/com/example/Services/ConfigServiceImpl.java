package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Config;
import com.example.Repositories.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService
{
	@Autowired
	private ConfigRepository configRepository;

	//getall
	@Override
	public List<Config> getAllConfigs() {
		
		return configRepository.findAll();
	}

	//getbyID
	@Override
	public Config getConfigById(int configId) {
		
		return configRepository.findById(configId).get();
	}

	//insert
	@Override
	public Config addConfig(Config config) {
		
		return configRepository.save(config);
	}


	//update
    @Override
    public Config updateConfig(int configId, Config updatedConfig) {
        Config existingConfig = configRepository.findById(configId).orElse(null);

        if (existingConfig != null) {
           
            existingConfig.setConfigName(updatedConfig.getConfigName());

            
            return configRepository.save(existingConfig);
        }

        return null; 
    }

    //delete
	@Override
	public void deleteConfig(int configId) 
	{
		Config c= configRepository.findById(configId).get();
		if(c!=null) {
			configRepository.delete(c);
		}
	}

}
