package daohibernate;

import entity.ListoftopicsinmaterialEntity;
import entity.MaterialsEntity;
import entity.SectionsEntity;
import entity.TopicsEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;



public class ManageSections {
    public List<SectionsEntity> read(TopicsEntity topicsEntity){
        List<SectionsEntity> listOfSections = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Criteria sectionCriteria = session.createCriteria(SectionsEntity.class);
            sectionCriteria.add(Restrictions.eq("sectionTopicId", topicsEntity.getTopicId()));
            listOfSections = sectionCriteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return listOfSections;
    }
}
