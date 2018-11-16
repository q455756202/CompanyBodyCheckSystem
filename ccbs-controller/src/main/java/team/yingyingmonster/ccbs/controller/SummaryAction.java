package team.yingyingmonster.ccbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Report;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.DoctorMapperWeng;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.ReportMapperWeng;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private DoctorMapperWeng doctorMapperWeng;

    //跳转到小结管理界面
    @RequestMapping("/summarytable/index")
    public String summarytable(){
        return "doctorcheck/summarycommit";
    }

    //获取当前医生的小结
    @RequestMapping("/summarytableget")
    @ResponseBody
    public ResultMessage getSummaryList(@RequestBody int page, HttpSession session){
        Long accountid = ((Account)session.getAttribute("login-account")).getAccountid();
        Long doctorid = doctorMapperWeng.selectDeptByAccountId(accountid).getDoctorid();
        PageHelper.startPage(page,5);
        List<Report>reports = reportMapperWeng.selectsummarybydoctorid(doctorid);
        PageInfo<Report> reportPageInfo = new PageInfo<>(reports);
        return ResultMessage.createSuccessMessage("获取成功",reportPageInfo);
    }

    //获取小结详情
    @RequestMapping("/getsummarybyid")
    @ResponseBody
    public ResultMessage getSummaryById(@RequestBody Long reportid){
        Report report = reportMapperWeng.selectByReportId(reportid);
        return ResultMessage.createSuccessMessage("获取成功",report.getReportsummary());
    }

    //管理界面提交小结
    @RequestMapping("/summarycommit")
    @ResponseBody
    public ResultMessage summaryCommit(@RequestBody Map<String,Number> info,HttpSession session){
        Long reportid = info.get("reportid").longValue();
        int page = info.get("page").intValue();
        reportMapperWeng.updateStateByReportId(reportid);
//        return ResultMessage.createSuccessMessage("提交成功","/summary/summarytable?page="+page);
        return getSummaryList(page,session);
    }

    //管理界面保存小结
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
