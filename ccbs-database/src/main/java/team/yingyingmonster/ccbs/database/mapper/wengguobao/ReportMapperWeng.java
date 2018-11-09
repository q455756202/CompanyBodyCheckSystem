package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import team.yingyingmonster.ccbs.database.bean.Report;

import java.util.List;

public interface ReportMapperWeng {
    public int insertdefaultreport(Report report);
    public List<Report> selectbybillid(Long billid);
    public int updateSummaryByBillid(Report report);
    public List<Report> selectsummarybydoctorid(Long doctorid);
    public Report selectByReportId(Long reportid);
    public int updateStateByReportId(Long reportid);
    public int updateSummaryByReportid(Report report);
    public List<Report> selectAllSummaryName();
    public List<Report> selectAllSummaryByUsercheckId(Long usercheckid);
    public int addSummaryAllReport(Report report);
}
