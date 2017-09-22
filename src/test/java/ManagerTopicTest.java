
import daohibernate.ManageTopics;
import entity.ListoftopicsinmaterialEntity;
import entity.TopicsEntity;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by k.kotov on 27.08.2017.
 */
public class ManagerTopicTest {
    static TopicsEntity expectedTopic = new TopicsEntity();
    static TopicsEntity actualTopic = null;

    @BeforeClass
    public static void setUpClass(){
        expectedTopic.setTopicId(9);
        expectedTopic.setTopicName("Тестовая тема");
        expectedTopic.setTopicDescription("Описание тестовой темы");

        ListoftopicsinmaterialEntity listOfTopic = new ListoftopicsinmaterialEntity();
        listOfTopic.setListTopicId(9);


        ManageTopics manageTopics = new ManageTopics();
        actualTopic = manageTopics.read(listOfTopic);
    }

    @Test
    public  void  testRead(){
        assertEquals(expectedTopic.getTopicId(), actualTopic.getTopicId());
        assertEquals(expectedTopic.getTopicName(), actualTopic.getTopicName());
        assertEquals(expectedTopic.getTopicDescription(), actualTopic.getTopicDescription());
    }
}
