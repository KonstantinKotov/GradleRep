package springdao;

import entity.UsersAccessEntity;
import entity.UsersEntity;

import javax.transaction.Transactional;

/**
 * Created by k.kotov on 05.10.2017.
 */
@Transactional
public interface UserInt {
    UsersEntity read(UsersAccessEntity usersAccessEntity);
}
