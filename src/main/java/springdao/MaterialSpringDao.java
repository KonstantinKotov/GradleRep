package springdao;

import entity.MaterialsEntity;
import entity.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MaterialSpringDao implements MaterialInt {

    @Autowired
    SessionFactory sessionFactory;

   public MaterialsEntity read(UsersEntity usersEntity){
       List<MaterialsEntity> materialsEntityList;
       Criteria materialsCriteria = sessionFactory.getCurrentSession().createCriteria(MaterialsEntity.class);
       materialsCriteria.add(Restrictions.eq("materialId", usersEntity.getUserMaterialId()));
       materialsEntityList = materialsCriteria.list();
       return materialsEntityList.get(0);
   }
}
