package springdao;

import entity.SectionsEntity;
import entity.TopicsEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by k.kotov on 05.10.2017.
 */
@Transactional
public interface SectionInt {
    List<SectionsEntity> read(TopicsEntity topicsEntity);
}
