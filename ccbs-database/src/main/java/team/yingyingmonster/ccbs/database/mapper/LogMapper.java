package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Log;

import java.util.List;

@Repository
public interface LogMapper {
    Log selectByPrimaryKey(Long logid);
    int deleteByPrimaryKey(Long logid);
    int insert(Log log);
    int insertSelective(Log logs);
    int updateByPrimaryKeySelective(Log logs);
    int updateByPrimaryKeyWithBLOBs(Log log);
    int updateByPrimaryKey(Log log);
}
