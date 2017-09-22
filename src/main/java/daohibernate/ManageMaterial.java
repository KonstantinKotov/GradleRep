package daohibernate;

import entity.MaterialsEntity;
import entity.UsersAccessEntity;
import entity.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;




public class ManageMaterial {


    public MaterialsEntity read(UsersEntity usersEntity){
        List<MaterialsEntity> material = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Criteria materialCriteria = session.createCriteria(MaterialsEntity.class);
            materialCriteria.add(Restrictions.eq("materialId", usersEntity.getUserMaterialId()));
            material = materialCriteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return material.get(0);
    }
}
