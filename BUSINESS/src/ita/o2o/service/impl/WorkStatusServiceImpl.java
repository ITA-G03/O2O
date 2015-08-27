package ita.o2o.service.impl;

import ita.o2o.dao.impl.WorkStatusDaoImpl;
import ita.o2o.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Service("workStatusService")
public class WorkStatusServiceImpl implements WorkStatusService {
    @Autowired
    WorkStatusDaoImpl workStatusDao;
}
