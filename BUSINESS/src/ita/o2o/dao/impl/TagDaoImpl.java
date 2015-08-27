package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.extra.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Repository("tagDao")
public class TagDaoImpl extends BaseDaoImpl<Tag>{

    public TagDaoImpl() {
        super(Tag.class);
    }

    @Override
    public List<Tag> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaQuery=criteriaBuilder.createQuery(Tag.class);
        Root<Tag> root=criteriaQuery.from(Tag.class);
        List<Tag> resultList=this.getManager().createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @Override
    public int create(Tag tag) {
        try{
            this.getManager().persist(tag);
            return tag.getTagId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
