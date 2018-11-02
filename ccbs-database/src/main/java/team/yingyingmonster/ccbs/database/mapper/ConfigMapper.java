package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Config;

import java.util.List;

public interface ConfigMapper {
    Config selectByPrimaryKey(Long configid);
    int deleteByPrimaryKey(Long configid);
    int insert(Config config);
    int insertSelective(Config configs);
    int updateByPrimaryKeySelective(Config configs);
    int updateByPrimaryKey(Config config);
}
