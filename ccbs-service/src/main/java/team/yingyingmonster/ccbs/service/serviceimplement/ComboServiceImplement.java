package team.yingyingmonster.ccbs.service.serviceimplement;

import team.yingyingmonster.ccbs.database.bean.Combo;
import team.yingyingmonster.ccbs.service.serviceinterface.ComboService;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:54 2018/11/2
 * - 套餐管理
 **/

public class ComboServiceImplement implements ComboService {

    @Override
    public Combo selectByPrimaryKey(Long comboid) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Long comboid) {
        return 0;
    }

    @Override
    public int insert(Combo combo) {
        return 0;
    }

    @Override
    public int insertSelective(Combo combos) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Combo combos) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Combo combo) {
        return 0;
    }
}
