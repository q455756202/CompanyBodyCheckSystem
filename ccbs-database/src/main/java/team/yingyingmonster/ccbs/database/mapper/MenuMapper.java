package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Menu;

import java.util.List;

public interface MenuMapper {
    Menu selectByPrimaryKey(Long menuid);
    int deleteByPrimaryKey(Long menuid);
    int insert(Menu menu);
    int insertSelective(Menu menus);
    int updateByPrimaryKeySelective(Menu menu);
}
