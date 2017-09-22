package daohibernate;

import entity.UsersAccessEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class ManageAccess {


    public  UsersAccessEntity read(String login){
        List<UsersAccessEntity> usersAccess = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Criteria userAccessCriteria = session.createCriteria(UsersAccessEntity.class);
            userAccessCriteria.add(Restrictions.eq("accessLogin", login));
            usersAccess = userAccessCriteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return usersAccess.get(0);
    }
}
