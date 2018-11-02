package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.ModelData;

@Repository
public interface ModelDataMapper {
    ModelData selectByPrimaryKey(Long modeldataid);
    int deleteByPrimaryKey(Long modeldataid);
    int insert(ModelData modelData);
    int insertSelective(ModelData modelData);
    int updateByPrimaryKeySelective(ModelData modelData);
    int updateByPrimaryKey(ModelData modelData);
}
