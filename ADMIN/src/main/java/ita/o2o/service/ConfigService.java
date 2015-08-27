package ita.o2o.service;

import ita.o2o.entity.admin.Configuration;

import java.util.List;

public interface ConfigService {

	public List<Configuration> getAllType();
	public boolean update(Configuration config);
	public void create(Configuration config);
	public void delete(Configuration config);
	
}
