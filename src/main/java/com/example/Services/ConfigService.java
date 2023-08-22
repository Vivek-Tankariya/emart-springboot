package com.example.Services;

import java.util.List;

import com.example.Entity.Config;

public interface ConfigService {

	List<Config> getAllConfigs();

	Config getConfigById(int configId);

	Config addConfig(Config config);

	Config updateConfig(int configId, Config updatedConfig);

	void deleteConfig(int configId);

	

}
