package team.yingyingmonster.ccbs.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Model;
import team.yingyingmonster.ccbs.database.bean.ModelData;
import team.yingyingmonster.ccbs.database.bean.Report;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.ModelMapperWeng;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.ReportMapperWeng;
import team.yingyingmonster.ccbs.service.serviceinterface.DoctorCheckService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyCheckSystem
 * - create: 13:20 2018/10/30
 * - 医生检查控制类
 **/
@Controller
@RequestMapping("/doctorcheck")
public class DoctorCheckAction {
    @Autowired
    private ModelMapperWeng modelMapperWeng;
    @Autowired
    private DoctorCheckService doctorCheckService;
    @Autowired
    private ReportMapperWeng reportMapperWeng;

    @RequestMapping("/index")
    public String index(){
        return "doctorcheck/index";
    }

    @RequestMapping("/userinfo")
    public String userInfo(){
        return "doctorcheck/user-info";
    }

    @RequestMapping("/modelinfo")
    public String modelInfo(){
        return "doctorcheck/model-info";
    }

    @RequestMapping("/modeldata")
    @ResponseBody
    public List<Model> modeldata(@RequestBody Long checkid){
        List<Model> models = modelMapperWeng.selectByCheckId(checkid);
        return models;
    }

    @RequestMapping("/insertmodeldata")
    @ResponseBody
    public List<ModelData> insertmodeldata(@RequestBody List<Model> models, Long billid, Long usercheckid) throws Exception {
        List<ModelData> modelDatas = new ArrayList<>();
        for (Model model:models){
            ModelData modelData = new ModelData();
            modelData.setModelvalue(model.getRecorddefault());
            modelData.setRecordid(model.getRecordid());
            modelData.setUsercheckid(usercheckid);
            modelDatas.add(modelData);
        }
        doctorCheckService.insertModelDataAndChangeBill(modelDatas,billid);
        return modelDatas;
    }

    @RequestMapping("/summary")
    public String summary(){

        return "doctorcheck/summary";
    }

    @RequestMapping("/summarytemplet")
    public String summarytemplet(){

        return "doctorcheck/summarytemplet";
    }

    @RequestMapping("/submitsummary")
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultMessage submitsummary(@RequestParam("summary") String summary,@RequestParam("billid") Long billid){
        System.out.println(summary);
        Report report = new Report();
        report.setBillid(billid);
        report.setReportsummary(summary);
        reportMapperWeng.updatesummarybyrepo(report);
        return ResultMessage.createSuccessMessage("成功添加小结,在后台确认后可正式提交","/doctorcheck/userinfo");
    }
}
