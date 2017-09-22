
import daohibernate.ManageSections;
import entity.SectionsEntity;
import entity.TopicsEntity;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ManagerSectionTest {

        static List<SectionsEntity> expectedList = new ArrayList<>();
        static List<SectionsEntity> actualList;
        static SectionsEntity expectedSection = new SectionsEntity();

        @BeforeClass
        public static void setUpClass(){
            expectedSection.setSectionTopicId(9);
            expectedSection.setSectionName("Тестовый раздел");
            expectedSection.setSectionContent("Содержание Т8 Р1");

            expectedList.add(expectedSection);

            TopicsEntity topic = new TopicsEntity();
            topic.setTopicId(9);


            ManageSections manageSections = new ManageSections();
            actualList = manageSections.read(topic);


        }

        @Test
        public void testRead(){
            assertEquals(expectedList.get(0).getSectionTopicId(), actualList.get(0).getSectionTopicId());
            assertEquals(expectedList.get(0).getSectionName(), actualList.get(0).getSectionName());
            assertEquals(expectedList.get(0).getSectionContent(), actualList.get(0).getSectionContent());
        }
}
