package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Bill;
import team.yingyingmonster.ccbs.database.bean.Report;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerBillMapper;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.ReportMapperWeng;
import team.yingyingmonster.ccbs.service.serviceinterface.DoctorCheckService;

import java.util.List;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 10:03 2018/11/8
 * - 体检总结管理
 **/

@Controller
@RequestMapping("/summaryall")
public class SummaryAllAction {
    @Autowired
    private ReportMapperWeng reportMapperWeng;
    @Autowired
    private JuerBillMapper juerBillMapper;
    @Autowired
    private DoctorCheckService doctorCheckService;

    //跳转到总结界面
    @RequestMapping("/summaryall/index")
    public String summaryall(){
        return "doctorcheck/summaryall";
    }

    //获取可总结列表
    @RequestMapping("/getsummaryall")
    @ResponseBody
    public ResultMessage getsummaryall(){
        List<Report> reports = reportMapperWeng.selectAllSummaryName();
        return ResultMessage.createSuccessMessage("获取可总结人员成功",reports);
    }

    //总结界面查看小结信息
    @RequestMapping("/getsummarybyuser")
    @ResponseBody
    public ResultMessage getSummaryByUser(@RequestBody Long usercheckid){
        List<Report> reports = reportMapperWeng.selectAllSummaryByUsercheckId(usercheckid);
        return ResultMessage.createSuccessMessage("获取该人员体检小结成功",reports);
    }

    //总结界面查看小结
    @RequestMapping("/getsummarydata")
    @ResponseBody
    public ResultMessage getSummaryData(@RequestBody Long reportid){
        Report report = reportMapperWeng.selectByReportId(reportid);
        return ResultMessage.createSuccessMessage("获取小结数据成功",report);
    }

    //提交总结
    @RequestMapping("/summaryallcommit")
    @ResponseBody
    public ResultMessage summaryAllCommit(@RequestParam("summaryall") String summaryall,@RequestParam("usercheckid") Long usercheckid) throws Exception {
        Long billid = juerBillMapper.getNewId();
        Bill bill = new Bill();
        bill.setBillid(billid);
        bill.setUsercheckid(usercheckid);
        Report report = new Report();
        report.setBillid(billid);
        report.setReportsummary(summaryall);
        doctorCheckService.insertSummaryAllReport(bill,report);
        return ResultMessage.createSuccessMessage("总结提交成功","/summaryall/summaryall");
    }
}
