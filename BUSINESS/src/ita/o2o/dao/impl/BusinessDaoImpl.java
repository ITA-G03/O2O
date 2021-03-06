package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import ita.o2o.entity.base.User;
import ita.o2o.entity.location.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by WhiteSaber on 15/8/26.
 */
@Repository("businessDao")
public class BusinessDaoImpl extends BaseDaoImpl<Business> {
    public static final String BUSINESS = "business";
    public static final String USER = "owner";
    public static final String CUSTOMER = "customer";

    public static final String BUSINESS_TAG="businessTag";
    public static final String BUSINESS_TAG_NAME="businessTagName";
    public static final String BUSINESS_TAG_ID="businessTagId";

    public static final String LOCATION="location";

    public BusinessDaoImpl() {
        super(Business.class);
    }


    @Override
    public List<Business> getAll() {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Business> criteriaQuery = criteriaBuilder.createQuery(Business.class);
        Root<Business> root = criteriaQuery.from(Business.class);
        List<Business> resultList = this.getManager().createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @Override
    public int create(Business business) {
        try {
            this.getManager().persist(business);
            return business.getBusinessId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }

    public Business getByUser(User user) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Business> criteriaBuilderQuery = criteriaBuilder.createQuery(Business.class);
        Root<Business> root = criteriaBuilderQuery.from(Business.class);


        System.out.println("Join表查询啦~~");
//        root.fetch(USER, JoinType.LEFT);
        Predicate predicate = criteriaBuilder.conjunction();
        Predicate equalPredicate = criteriaBuilder.equal(root.<User>get(USER), user);
        predicate = criteriaBuilder.and(predicate, equalPredicate);
        criteriaBuilderQuery.select(root).where(predicate);

        List<Business> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~resultList Size:" + resultList.size());
        if(resultList.size()>0)return resultList.get(0);
//        result.getBusinessTags().size();

        return null;
    }

    public List<Business> getAllByTag(BusinessTag businessTag) {
        return null;
    }

    public List<Business> getAllByLocation(Location location) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();


        CriteriaQuery<Business> criteriaBuilderQuery = criteriaBuilder.createQuery(Business.class);
        Root<Business> root = criteriaBuilderQuery.from(Business.class);




        System.out.println("Join表查询啦~~");
        Predicate predicate = criteriaBuilder.conjunction();
        Predicate equalPredicate = criteriaBuilder.equal(root.<Location>get(LOCATION), location);
        predicate = criteriaBuilder.and(predicate, equalPredicate);
        criteriaBuilderQuery.select(root).where(predicate);

        List<Business> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~BusinessId:" + resultList.size());
        return resultList;
    }

    public List<Business> getAllByLocationList(List<Location> locationList) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();


        CriteriaQuery<Business> criteriaBuilderQuery = criteriaBuilder.createQuery(Business.class);
        Root<Business> root = criteriaBuilderQuery.from(Business.class);




        System.out.println("Join表查询啦~~");
        Predicate predicate = criteriaBuilder.conjunction();

        for(Location location:locationList){
            Predicate equalPredicate = criteriaBuilder.and(criteriaBuilder.equal(root.<Location>get(LOCATION), location));
            predicate = criteriaBuilder.or(predicate, equalPredicate);
        }

        criteriaBuilderQuery.select(root).where(predicate);

        List<Business> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~符合location list的business总数:" + resultList.size());
        return resultList;
    }
}
