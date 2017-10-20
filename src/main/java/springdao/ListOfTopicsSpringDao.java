package springdao;

import entity.ListoftopicsinmaterialEntity;
import entity.MaterialsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ListOfTopicsSpringDao implements ListOfTopInt {

    @Autowired
    SessionFactory sessionFactory;

    public List<ListoftopicsinmaterialEntity> read(MaterialsEntity materialsEntity){
       List<ListoftopicsinmaterialEntity> listOfTopics;
        Criteria listCriteria = sessionFactory.getCurrentSession().createCriteria(ListoftopicsinmaterialEntity.class);
        listCriteria.add(Restrictions.eq("listMaterialId", materialsEntity.getMaterialId()));
        listOfTopics = listCriteria.list();
        return listOfTopics;
    }
}
