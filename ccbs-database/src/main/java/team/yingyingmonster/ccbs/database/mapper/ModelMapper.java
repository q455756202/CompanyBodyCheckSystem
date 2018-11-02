package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Model;

public interface ModelMapper {
    Model selectByPrimaryKey(Long modelid);
    int deleteByPrimaryKey(Long modelid);
    int insert(Model model);
    int insertSelective(Model model);
    int updateByPrimaryKeySelective(Model model);
    int updateByPrimaryKey(Model model);
}
