package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Statement;

public interface StatementMapper {
    Statement selectByPrimaryKey(Long statementid);
    int deleteByPrimaryKey(Long statementid);
    int insert(Statement statement);
    int insertSelective(Statement statement);
    int updateByPrimaryKeySelective(Statement statement);
    int updateByPrimaryKey(Statement statement);
}
