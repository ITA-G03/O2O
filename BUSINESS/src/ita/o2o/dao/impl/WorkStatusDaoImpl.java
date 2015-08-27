package ita.o2o.dao.impl;

import ita.o2o.entity.extra.WorkStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Repository("workStatusDao")
public class WorkStatusDaoImpl extends BaseDaoImpl<WorkStatus> {

    public WorkStatusDaoImpl() {
        super(WorkStatus.class);
    }

    @Override
    public List<WorkStatus> getAll() {
        return null;
    }

    @Override
    public int create(WorkStatus workStatus) {
        return 0;
    }
}
