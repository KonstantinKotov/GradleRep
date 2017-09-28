import daohibernate.ManageMaterial;

import entity.MaterialsEntity;
import entity.UsersEntity;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by k.kotov on 22.09.2017.
 */
public class ManagerMaterialTest {
    static MaterialsEntity expectedMaterial = new MaterialsEntity();
    static MaterialsEntity actualMaterial;

    @BeforeClass
    public static void setUpClass(){
        expectedMaterial.setMaterialId(3);
        expectedMaterial.setMaterialName("Тестовый материал");
        expectedMaterial.setMaterialDescription("Описаниетестового материала");

        UsersEntity user = new UsersEntity();
        user.setUserMaterialId(1);


        ManageMaterial manageMaterial = new ManageMaterial();
        actualMaterial = manageMaterial.read(user);
    }

    @Test
    public  void  testRead(){
        assertEquals(expectedMaterial.getMaterialId(), actualMaterial.getMaterialId());
        assertEquals(expectedMaterial.getMaterialName(), actualMaterial.getMaterialName());
        assertEquals(expectedMaterial.getMaterialDescription(), actualMaterial.getMaterialDescription());
    }
}
