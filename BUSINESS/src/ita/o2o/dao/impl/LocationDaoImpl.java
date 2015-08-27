package ita.o2o.dao.impl;

import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Repository("locationDao")
public class LocationDaoImpl extends BaseDaoImpl<Location> {

    public static final String CITY="city";

    LocationDaoImpl() {
        super(Location.class);
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    @Override
    public int create(Location location) {
        return 0;
    }

    public List<Location> getByCity(City city) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Location> criteriaBuilderQuery = criteriaBuilder.createQuery(Location.class);
        Root<Location> root = criteriaBuilderQuery.from(Location.class);


        System.out.println("Join表查询啦~~");
        Predicate predicate=criteriaBuilder.conjunction();
        Predicate equalPredicate=criteriaBuilder.equal(root.<City>get(CITY),city);
        predicate=criteriaBuilder.and(predicate,equalPredicate);
        criteriaBuilderQuery.select(root).where(predicate);
        List<Location> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~Size:"+resultList.size());
        return resultList;
    }
}
