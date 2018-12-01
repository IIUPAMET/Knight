package model.dao;

import model.entity.Thing;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DAOThing {

    List<Thing> getAll();

    List<Thing> getInPriceDiapason(Integer minPrice, Integer maxPrice);

    void update(Thing entity);

    Thing getEntityById(Integer id);

    boolean delete(Integer id);

    boolean create(Thing entity);
}
