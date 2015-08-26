package ita.o2o.service.impl;

import ita.o2o.dao.impl.RoleDaoImpl;
import ita.o2o.entity.extra.Role;
import ita.o2o.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jason Cui
 * @version 2015-08-26
 */

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDaoImpl roleDao;

    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }
}
