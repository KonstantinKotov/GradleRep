package springdao;

import entity.UsersAccessEntity;

import javax.transaction.Transactional;

/**
 * Created by k.kotov on 05.10.2017.
 */
@Transactional
public interface AccessInt {
    UsersAccessEntity read(String login);
}
