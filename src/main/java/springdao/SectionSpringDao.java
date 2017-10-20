package springdao;

import entity.SectionsEntity;
import entity.TopicsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SectionSpringDao implements SectionInt {
    @Autowired
    SessionFactory sessionFactory;

    public List<SectionsEntity> read(TopicsEntity topicsEntity){
        List<SectionsEntity> sectionsEntities;
        Criteria sectionCriteria =sessionFactory.getCurrentSession().createCriteria(SectionsEntity.class);
        sectionCriteria.add(Restrictions.eq("sectionTopicId", topicsEntity.getTopicId()));
        sectionsEntities = sectionCriteria.list();
        return sectionsEntities;
    }
}
