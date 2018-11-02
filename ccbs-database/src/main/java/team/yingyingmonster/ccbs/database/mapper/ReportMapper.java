package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Report;

public interface ReportMapper {
    Report selectByPrimaryKey(Long reportid);
    int deleteByPrimaryKey(Long reportid);
    int insert(Report report);
    int insertSelective(Report report);
    int updateByPrimaryKeySelective(Report report);
    int updateByPrimaryKeyWithBLOBs(Report report);
    int updateByPrimaryKey(Report report);
}
