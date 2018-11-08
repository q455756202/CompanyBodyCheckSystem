package team.yingyingmonster.ccbs.database.mapper.dingli;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Check;

import java.util.List;
@Repository
public interface DingCheckListMapper {
    List<Check> selectAllCheck();
}
