package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Excel;

import java.util.List;

@Repository
public interface ExcelMapper {
    Excel selectByPrimaryKey(Long excelid);
    int deleteByPrimaryKey(Long excelid);
    int insert(Excel excel);
    int insertSelective(Excel excels);
    int updateByPrimaryKeySelective(Excel excels);
    int updateByPrimaryKey(Excel excel);
}
