package springdao;

import entity.ListoftopicsinmaterialEntity;
import entity.TopicsEntity;
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
public class TopicSpringDao implements TopicInt {
    @Autowired
    SessionFactory sessionFactory;

    public TopicsEntity read(ListoftopicsinmaterialEntity listoftopicsinmaterialEntity){
        List<TopicsEntity> topicsEntities;
        Criteria topicCritera = sessionFactory.getCurrentSession().createCriteria(TopicsEntity.class);
        topicCritera.add(Restrictions.eq("topicId", listoftopicsinmaterialEntity.getListTopicId()));
        topicsEntities = topicCritera.list();
        return topicsEntities.get(0);
    }
}
