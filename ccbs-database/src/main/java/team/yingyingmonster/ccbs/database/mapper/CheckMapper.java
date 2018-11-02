package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Check;

import java.util.List;

@Repository
public interface CheckMapper {
    Check selectByPrimaryKey(Long checkid);
    int deleteByPrimaryKey(Long checkid);
    int insert(Check check);
    int insertSelective(Check checks);
    int updateByPrimaryKeySelective(Check checks);
    int updateByPrimaryKey(Check check);
}
