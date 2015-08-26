package ita.o2o.dao.impl;

import ita.o2o.entity.base.Comment;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by YUKE on 8/25/2015.
 */

@Component("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment>{

    public List<Comment> getCommentListByBusinessId(int businessId){
        String hql = "FROM Comment C WHERE C.business.businessId =: businessId";
        Query query = this.getManager().createQuery(hql);
        query.setParameter("businessId", businessId);
        return query.getResultList();
    }

    @Override
    public <T> T getById(int id) {
        return null;
    }
}
