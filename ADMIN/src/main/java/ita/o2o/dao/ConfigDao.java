package ita.o2o.dao;

import ita.o2o.entity.admin.Configuration;

import java.util.List;

public interface ConfigDao {
	public List<Configuration> getAll();
	
	public Configuration getIdByName(String name);

	public boolean update(Configuration config);
	
	public void create(Configuration config);
	
	public boolean delete(Configuration config);
}
