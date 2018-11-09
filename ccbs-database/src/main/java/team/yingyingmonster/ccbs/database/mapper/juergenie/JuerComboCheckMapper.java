package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.apache.ibatis.annotations.Options;
import team.yingyingmonster.ccbs.database.bean.Check;
import team.yingyingmonster.ccbs.database.bean.Combo;

import java.util.List;

public interface JuerComboCheckMapper {
    Long getNewId();
    List<Check> selectChecksByComboid(Long comboid);
    List<Combo> selectCombosByCheckid(Long checkid);
}
