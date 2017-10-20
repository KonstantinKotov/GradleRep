package springdao;

import entity.MaterialsEntity;
import entity.UsersEntity;

import javax.transaction.Transactional;

@Transactional
public interface MaterialInt {
    MaterialsEntity read(UsersEntity usersEntity);
}
