package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Combo;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCombo;

import java.util.List;

@Repository
public interface JuerComboMapper {
    List<Combo> selectAllCombo();
    List<Combo> selectComboByCondition(Combo condition);
    List<JuerCombo> selectAllJuerCombo();
    List<JuerCombo> selectJuerComboByCondition(Combo condition);
    Double selectAllPriceByComboList(List<Combo> comboList);
    Double selectAllPriceByJuerComboList(List<JuerCombo> juerComboList);
    Long getNewId();
}
