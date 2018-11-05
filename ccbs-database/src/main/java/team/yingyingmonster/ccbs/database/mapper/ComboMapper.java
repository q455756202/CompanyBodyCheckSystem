package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Combo;

import java.util.List;

@Repository
public interface ComboMapper {
    Combo selectByPrimaryKey(Long comboid);
    int deleteByPrimaryKey(Long comboid);
    int insert(Combo combo);
    int insertSelective(Combo combos);
    int updateByPrimaryKeySelective(Combo combos);
    int updateByPrimaryKey(Combo combo);
}
