package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Statement;

@Repository
public interface StatementMapper {
    Statement selectByPrimaryKey(Long statementid);
    int deleteByPrimaryKey(Long statementid);
    int insert(Statement statement);
    int insertSelective(Statement statement);
    int updateByPrimaryKeySelective(Statement statement);
    int updateByPrimaryKey(Statement statement);
}
