package team.yingyingmonster.ccbs.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.czh.PdfUitl;
import team.yingyingmonster.ccbs.database.bean.Report;
import team.yingyingmonster.ccbs.database.mapper.czh.AllReportMapper;

import java.util.List;

/**
 * 生成pdf文件，打印
 */
@Controller
@RequestMapping("/all-report")
public class AllReportAction {
    @Autowired
    private AllReportMapper allReportMapper;
    private PdfUitl pdfUitl =new PdfUitl();
    /**
     * 跳转界面
     */
    @RequestMapping("/all-report")
    private  String clob(){
        return "all-report/all-report";
    }

    /**
     * 获取团检报告列表
     * @return
     */
    @RequestMapping("/report-list")
    @ResponseBody
    private ResultMessage getAllReport(){
        PageHelper.startPage(1,6);
        PageHelper.orderBy("reportid");
        List<Report> allreport=allReportMapper.selectAllReport();

        return ResultMessage.createSuccessMessage("获取的团检报告",allreport);
    }
    /**
     * 预览界面
     */
    @RequestMapping("/report-summary")
    @ResponseBody
    private ResultMessage getReportSummary(@RequestBody Long reportid){
        String pdfpath=pdfUitl.PdfPath(reportid);
        pdfUitl.htmlCodeComeFromFile(String.valueOf(allReportMapper.selectReportSummary(reportid)),pdfpath);
        return ResultMessage.createSuccessMessage("获取pdf文件的路径",pdfpath);
    }
}

