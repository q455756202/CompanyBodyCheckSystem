package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Config;

import java.util.List;

@Repository
public interface ConfigMapper {
    Config selectByPrimaryKey(Long configid);
    int deleteByPrimaryKey(Long configid);
    int insert(Config config);
    int insertSelective(Config configs);
    int updateByPrimaryKeySelective(Config configs);
    int updateByPrimaryKey(Config config);
}
