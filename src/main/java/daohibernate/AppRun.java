package daohibernate;

import entity.UsersAccessEntity;
import entity.UsersEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import springdao.AccessInt;
import springdao.AccessSpringDao;
import springdao.UserInt;


public class AppRun {
    public static void main(String [] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);

        AccessInt accessDao =
                (AccessInt) context.getBean("accessSpringDao");
        UserInt userDao =
               (UserInt) context.getBean("userSpringDao");

        UsersAccessEntity usersAccessEntity = accessDao.read("test");
        System.out.println(usersAccessEntity.getAccessId());
        System.out.println(usersAccessEntity.getAccessLogin());
        System.out.println(usersAccessEntity.getAccessPassword());

        UsersEntity usersEntity = userDao.read(usersAccessEntity);
        System.out.println(usersEntity.getUserFirstName());
        System.out.println(usersEntity.getUserDepartment());
        System.out.println(usersEntity.getUserPosition());


    }
}
