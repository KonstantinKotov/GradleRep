
import daohibernate.ManageListOfTopics;
import entity.ListoftopicsinmaterialEntity;
import entity.MaterialsEntity;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ManagerListOfTopicsTest {
    static List<ListoftopicsinmaterialEntity> expectedList = new ArrayList<>();
    static List<ListoftopicsinmaterialEntity> actualList;
    static ListoftopicsinmaterialEntity expectedListTop = new ListoftopicsinmaterialEntity();
    static ListoftopicsinmaterialEntity actualListTop;

    @BeforeClass
    public static void setUpClass(){
        expectedListTop.setListId(10);
        expectedListTop.setListMaterialId(3);
        expectedListTop.setListTopicId(9);


        expectedList.add(expectedListTop);

        MaterialsEntity infoMaterial = new MaterialsEntity();
        infoMaterial.setMaterialId(3);

        ManageListOfTopics manageListOfTopics = new ManageListOfTopics();
        actualList = manageListOfTopics.read(infoMaterial);

    }

    @Test
    public void testRead(){
        assertEquals(expectedList.get(0).getListId(), actualList.get(0).getListId());
        assertEquals(expectedList.get(0).getListTopicId(), actualList.get(0).getListTopicId());
    }
}
