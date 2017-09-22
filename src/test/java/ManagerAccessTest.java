

import daohibernate.ManageAccess;
import entity.UsersAccessEntity;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ManagerAccessTest {

    @Test
    public void testRead() throws Exception{
        String expectedlogin = "test";
        String expectedPassword = "test321";

        List<UsersAccessEntity> usersAccess = null;

        ManageAccess manageAccess = new ManageAccess();
        UsersAccessEntity usersAccessEntity = manageAccess.read("test");

        assertEquals(expectedlogin, usersAccessEntity.getAccessLogin());
        assertEquals(expectedPassword, usersAccessEntity.getAccessPassword());

    }
}
