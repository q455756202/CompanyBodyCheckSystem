package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.ComboCheck;

import java.util.List;

@Repository
public interface ComboCheckMapper {
    ComboCheck selectByPrimaryKey(Long combocheckid);
    int deleteByPrimaryKey(Long combocheckid);
    int insert(ComboCheck comboCheck);
    int insertSelective(ComboCheck comboChecks);
    int updateByPrimaryKeySelective(ComboCheck comboChecks);
    int updateByPrimaryKey(Long combocheckid);
}
