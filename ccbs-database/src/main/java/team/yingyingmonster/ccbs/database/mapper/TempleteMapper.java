package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Templete;

@Repository
public interface TempleteMapper {
    Templete selectByPrimaryKey(Long templeteid);
    int deleteByPrimaryKey(Long templeteid);
    int insert(Templete templete);
    int insertSelective(Templete templete);
    int updateByPrimaryKeySelective(Templete templete);
    int updateByPrimaryKey(Templete templete);
}
