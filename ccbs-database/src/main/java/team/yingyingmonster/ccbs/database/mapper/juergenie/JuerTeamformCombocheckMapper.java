package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.apache.ibatis.annotations.Options;
import team.yingyingmonster.ccbs.database.bean.TeamformCombocheck;

import java.util.List;

public interface JuerTeamformCombocheckMapper {
    Long getNewId();
    int insertBatch(List<TeamformCombocheck> list);
}
