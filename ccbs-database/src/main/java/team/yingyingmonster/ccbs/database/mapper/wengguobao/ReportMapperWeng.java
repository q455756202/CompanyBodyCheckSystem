package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import team.yingyingmonster.ccbs.database.bean.Report;

import java.util.List;

public interface ReportMapperWeng {
    public int insertdefaultreport(Long billid);
    public List<Report> selectbybillid(Long billid);
    public int updatesummarybyrepo(Report report);
}
