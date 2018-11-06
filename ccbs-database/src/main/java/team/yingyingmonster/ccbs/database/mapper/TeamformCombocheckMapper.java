package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.TeamformCombocheck;

@Repository
public interface TeamformCombocheckMapper {
    TeamformCombocheck selectByPrimaryKey(Long teamformCombocheckId);
    int deleteByPrimaryKey(Long teamformCombocheckId);
    int insert(TeamformCombocheck teamformCombocheck);
    int insertSelective(TeamformCombocheck teamformCombocheck);
    int updateByPrimaryKeySelective(TeamformCombocheck teamformCombocheck);
    int updateByPrimaryKey(TeamformCombocheck teamformCombocheck);
}
