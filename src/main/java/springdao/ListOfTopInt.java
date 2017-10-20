package springdao;

import entity.ListoftopicsinmaterialEntity;
import entity.MaterialsEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by k.kotov on 05.10.2017.
 */
@Transactional
public interface ListOfTopInt {
   List<ListoftopicsinmaterialEntity> read(MaterialsEntity materialsEntity);
}
