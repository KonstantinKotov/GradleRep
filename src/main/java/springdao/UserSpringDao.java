package springdao;

import entity.UsersAccessEntity;
import entity.UsersEntity;
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
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserSpringDao implements UserInt {

    @Autowired
    SessionFactory sessionFactory;

    public UsersEntity read(UsersAccessEntity usersAccessEntity){
        List<UsersEntity> usersList;
        Criteria userCriteria = sessionFactory.getCurrentSession().createCriteria(UsersEntity.class);
        userCriteria.add(Restrictions.eq("userLogin", usersAccessEntity.getAccessId()));
        usersList = userCriteria.list();
        return usersList.get(0);
    }


}
