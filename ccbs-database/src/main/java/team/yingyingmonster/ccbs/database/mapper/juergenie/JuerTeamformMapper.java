package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.apache.ibatis.annotations.Options;
import team.yingyingmonster.ccbs.database.bean.Teamform;

import java.util.List;

public interface JuerTeamformMapper {
    List<Teamform> selectTeamformByCompanyId(Long companyid);
    Long getNewId();
    int insert(Teamform teamform);
}
