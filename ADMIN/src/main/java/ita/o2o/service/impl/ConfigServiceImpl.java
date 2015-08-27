package ita.o2o.service.impl;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public boolean update(Configuration config) {
		Configuration dbConfig=configDao.getIdByName(config.getName());
		dbConfig.setValue(config.getValue());
		boolean flag=configDao.update(dbConfig);
		return flag;
		
	}

	@Override
	public void create(Configuration config) {
	
	}

	@Override
	public void delete(Configuration config) {
		
	}

	

}
