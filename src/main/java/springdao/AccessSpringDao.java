package springdao;

import entity.UsersAccessEntity;
import entity.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccessSpringDao implements AccessInt{

    @Autowired
    SessionFactory sessionFactory;

    public UsersAccessEntity read(String login){
        Criteria userAccessCriteria = sessionFactory.getCurrentSession().createCriteria(UsersAccessEntity.class).
                add(Restrictions.eq("accessLogin", login));
       List<UsersAccessEntity> usersAccessEntity;
       usersAccessEntity = (List<UsersAccessEntity>) userAccessCriteria.list();
       return usersAccessEntity.get(0);
    }
}
