
import daohibernate.ManageUser;
import entity.UsersAccessEntity;
import entity.UsersEntity;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerUserTest {
    static UsersEntity userExpected = new UsersEntity();
    static UsersEntity user;


    @BeforeClass
    public  static void setUpClass(){

        userExpected.setUserId(5);
        userExpected.setUserFirstName("testUserName1");
        userExpected.setUserSecondName("testUserName2");
        userExpected.setUserMidName("testUserName3");
        userExpected.setUserSex("муж");
        userExpected.setUserPosition("Менеджер");
        userExpected.setUserDepartment("Отдел продаж");
        userExpected.setUserMaterialId(3);

        UsersAccessEntity access = new UsersAccessEntity();
        access.setAccessId(3);
        ManageUser manageUser = new ManageUser();
        user = manageUser.read(access);
    }

    @Test
    public  void testRead(){
        assertEquals(userExpected.getUserId(), user.getUserId());
        assertEquals(userExpected.getUserFirstName(), user.getUserFirstName());
        assertEquals(userExpected.getUserSecondName(), user.getUserSecondName());
        assertEquals(userExpected.getUserMidName(), user.getUserMidName());
        assertEquals(userExpected.getUserSex(), user.getUserSex());
        //assertEquals(userExpected.getBirthDate(), user.getBirthDate());
        //assertEquals(userExpected.getWorkFromDate(), user.getWorkFromDate());
        assertEquals(userExpected.getUserPosition(), user.getUserPosition());
        assertEquals(userExpected.getUserDepartment(), user.getUserDepartment());
        assertEquals(userExpected.getUserMaterialId(), user.getMaterialsByUserMaterialId().getMaterialId());
        //assertEquals(userExpected.getLogin(), user.getLogin());
    }
}
