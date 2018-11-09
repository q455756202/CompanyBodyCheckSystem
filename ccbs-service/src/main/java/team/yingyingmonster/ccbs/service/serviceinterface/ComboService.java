package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Combo;

public interface ComboService {
    Combo selectByPrimaryKey(Long comboid);
    int deleteByPrimaryKey(Long comboid);
    int insert(Combo combo);
    int insertSelective(Combo combos);
    int updateByPrimaryKeySelective(Combo combos);
    int updateByPrimaryKey(Combo combo);
}
