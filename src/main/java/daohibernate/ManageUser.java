package daohibernate;

import entity.UsersAccessEntity;
import entity.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by k.kotov on 12.09.2017.
 */
public class ManageUser {

    public UsersEntity read(UsersAccessEntity usersAccessEntity){
        List<UsersEntity> user = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

        Criteria userCriteria = session.createCriteria(UsersEntity.class);
        userCriteria.add(Restrictions.eq("userLogin", usersAccessEntity.getAccessId()));
        user = userCriteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user.get(0);
    }
}
