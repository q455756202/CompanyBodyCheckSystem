package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Teamform;

public interface TeamformMapper {
    Teamform selectByPrimaryKey(Long teamformid);
    int deleteByPrimaryKey(Long teamformid);
    int insert(Teamform teamform);
    int insertSelective(Teamform teamform);
    int updateByPrimaryKeySelective(Teamform teamform);
    int updateByPrimaryKey(Teamform teamform);
}
