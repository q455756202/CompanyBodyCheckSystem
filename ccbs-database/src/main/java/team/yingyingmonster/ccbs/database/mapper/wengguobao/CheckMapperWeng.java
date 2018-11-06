package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Check;

import java.util.List;

@Repository
public interface CheckMapperWeng {
    List<Check> selectCheckByDeptId(Long deptId);
}
