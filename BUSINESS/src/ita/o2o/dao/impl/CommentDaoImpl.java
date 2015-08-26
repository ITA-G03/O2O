package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
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
    public List<Comment> getAll() {
        return null;
    }


    @Override
    public int create(Comment comment) {
        try{
            this.getManager().persist(comment);
            return comment.getCommentId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
