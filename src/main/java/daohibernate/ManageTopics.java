package daohibernate;

import entity.ListoftopicsinmaterialEntity;
import entity.TopicsEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;




public class ManageTopics {

    public TopicsEntity read(ListoftopicsinmaterialEntity listOfTop){
        List<TopicsEntity> topic = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
    try{
        tx = session.beginTransaction();
        Criteria topicCriteria = session.createCriteria(TopicsEntity.class);
        topicCriteria.add(Restrictions.eq("topicId", listOfTop.getListTopicId()));
        topic = topicCriteria.list();
        tx.commit();
    }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace();
    }finally {
        session.close();
    }

        return topic.get(0);
    }
}
