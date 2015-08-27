package ita.o2o.service.impl;

import ita.o2o.dao.impl.StatusDaoImpl;
import ita.o2o.entity.extra.Status;
import ita.o2o.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDaoImpl statusDao;

    public Status getById(Integer id) {
        return statusDao.getById(id);
    }
}
