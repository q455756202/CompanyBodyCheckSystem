package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Report;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.ReportMapperWeng;

import java.util.List;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:15 2018/11/7
 * - 小结管理类
 **/
@Controller
@RequestMapping("/summary")
public class SummaryAction {
    @Autowired
    private ReportMapperWeng reportMapperWeng;

    @RequestMapping("/summarytable")
    public String summarytable(){
        return "doctorcheck/summarycommit";
    }

    @RequestMapping("/summarytableget")
    @ResponseBody
    public ResultMessage getSummaryList(){
        List<Report>reports = reportMapperWeng.selectsummarybydoctorid(1l);
        return ResultMessage.createSuccessMessage("获取成功",reports);
    }

    @RequestMapping("/getsummarybyid")
    @ResponseBody
    public ResultMessage getSummaryById(@RequestBody Long reportid){
        Report report = reportMapperWeng.selectByReportId(reportid);
        return ResultMessage.createSuccessMessage("获取成功",report.getReportsummary());
    }

    @RequestMapping("/summarycommit")
    @ResponseBody
    public ResultMessage summaryCommit(@RequestBody Long reportid){
        reportMapperWeng.updateStateByReportId(reportid);
        return ResultMessage.createSuccessMessage("提交成功","/summary/summarytable");
    }

    @RequestMapping("/summarysave")
    @ResponseBody
    public ResultMessage summarySave(@RequestParam("summary") String summary, @RequestParam("reportid") Long reportid){
        Report report = new Report();
        report.setReportsummary(summary);
        report.setReportid(reportid);
        reportMapperWeng.updateSummaryByReportid(report);
        return ResultMessage.createSuccessMessage("保存成功","");
    }
}
