package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.TeamformCombocheck;

public interface TeamformCombocheckMapper {
    TeamformCombocheck selectByPrimaryKey(Long teamformCombocheckId);
    int deleteByPrimaryKey(Long teamformCombocheckId);
    int insert(TeamformCombocheck teamformCombocheck);
    int insertSelective(TeamformCombocheck teamformCombocheck);
    int updateByPrimaryKeySelective(TeamformCombocheck teamformCombocheck);
    int updateByPrimaryKey(TeamformCombocheck teamformCombocheck);
}
