package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Combo;

import java.util.List;

@Repository
public interface JuerComboMapper {
    List<Combo> selectAllCombo();
    List<Combo> selectComboByCondition(Combo condition);
}
