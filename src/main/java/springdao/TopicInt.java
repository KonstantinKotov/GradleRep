package springdao;

import entity.ListoftopicsinmaterialEntity;
import entity.TopicsEntity;

import javax.transaction.Transactional;

/**
 * Created by k.kotov on 05.10.2017.
 */
@Transactional
public interface TopicInt {
    TopicsEntity read(ListoftopicsinmaterialEntity listoftopicsinmaterialEntity);
}
