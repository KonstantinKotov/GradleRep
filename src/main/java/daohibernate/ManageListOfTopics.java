package daohibernate;

import entity.ListoftopicsinmaterialEntity;
import entity.MaterialsEntity;
import entity.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class ManageListOfTopics {

    public List <ListoftopicsinmaterialEntity> read(MaterialsEntity materialsEntity){
        List<ListoftopicsinmaterialEntity> listOfTopics = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Criteria listCriteria = session.createCriteria(ListoftopicsinmaterialEntity.class);
            listCriteria.add(Restrictions.eq("listMaterialId", materialsEntity.getMaterialId()));
            listOfTopics = listCriteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return listOfTopics;
    }
}
