package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.ModelData;

public interface ModelDataMapper {
    ModelData selectByPrimaryKey(Long modeldataid);
    int deleteByPrimaryKey(Long modeldataid);
    int insert(ModelData modelData);
    int insertSelective(ModelData modelData);
    int updateByPrimaryKeySelective(ModelData modelData);
    int updateByPrimaryKey(ModelData modelData);
}
