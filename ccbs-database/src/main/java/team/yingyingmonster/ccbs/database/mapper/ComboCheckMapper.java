package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.ComboCheck;

import java.util.List;

public interface ComboCheckMapper {
    ComboCheck selectByPrimaryKey(Long combocheckid);
    int deleteByPrimaryKey(Long combocheckid);
    int insert(ComboCheck comboCheck);
    int insertSelective(ComboCheck comboChecks);
    int updateByPrimaryKeySelective(ComboCheck comboChecks);
    int updateByPrimaryKey(Long combocheckid);
}
