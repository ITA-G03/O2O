package ita.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.o2o.dao.impl.ConfigDaoImpl;
import ita.o2o.entity.admin.Configuration;
import ita.o2o.service.ConfigService;

@Service("configService")
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigDaoImpl configDao;
	
	@Override
	public List<Configuration> getAllType() {

		return null;
	}

	@Transactional
	public boolean update(Configuration config) {
		int id=configDao.getIdByName(config.getName());
		config.setId(id);
		boolean flag=configDao.update(config);
		return flag;
		
	}

	@Override
	public void create(Configuration config) {
	
	}

	@Override
	public void delete(Configuration config) {
		
	}

	

}
