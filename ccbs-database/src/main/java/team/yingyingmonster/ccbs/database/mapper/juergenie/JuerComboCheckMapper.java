package team.yingyingmonster.ccbs.database.mapper.juergenie;

import team.yingyingmonster.ccbs.database.bean.Check;
import team.yingyingmonster.ccbs.database.bean.Combo;

import java.util.List;

public interface JuerComboCheckMapper {
    Long getNewId();
    List<Check> selectChecksByComboid(Long comboid);
    List<Combo> selectCombosByCheckid(Long checkid);
}
