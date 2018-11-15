package team.yingyingmonster.ccbs.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.*;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.*;
import team.yingyingmonster.ccbs.service.serviceinterface.DoctorCheckService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private BillMapperWeng billMapperWeng;
    @Autowired
    private UserMapperWeng userMapperWeng;
    @Autowired
    private DoctorMapperWeng doctorMapperWeng;

    @RequestMapping("/index")
    public String index(){
        return "doctorcheck/index";
    }

    //跳转到体检单接收界面
    @RequestMapping("/userinfo/index")
    public String userInfo(){
        return "doctorcheck/user-info";
    }

    //跳转到细项界面
    @RequestMapping("/modelinfo")
    public String modelInfo(){
        return "doctorcheck/model-info";
    }

    //根据科室查出当前可进行体检的人员
    @RequestMapping("/getuserbydept")
    @ResponseBody
    public ResultMessage getUserByDept(HttpSession session){
        Long accountid = ((Account)session.getAttribute("login-account")).getAccountid();
        Long deptid = doctorMapperWeng.selectDeptByAccountId(accountid).getDeptByDeptid().getDeptid();
        List<Bill> bills = billMapperWeng.selectAllUserByDeptId(deptid);
        return ResultMessage.createSuccessMessage("获取可检人员名单成功",bills);
    }

    //根据用户id获取体检人信息及体检项目
    @RequestMapping("/getuserinfo")
    @ResponseBody
    public ResultMessage getUserInfo(@RequestBody Long userid,HttpSession session){
        User user = null;
        Doctor doctor = null;
        List<Bill> bills = null;
        Map<String,Object> map = new HashMap<>();
        user = userMapperWeng.selectUserByUserId(userid);
        Long accountid = ((Account)session.getAttribute("login-account")).getAccountid();
        doctor = doctorMapperWeng.selectDeptByAccountId(accountid);//获取部门id和名字
        bills = billMapperWeng.selectByDeptIdAndUserId(doctor.getDeptByDeptid().getDeptid(),userid);
        map.put("user",user);
        map.put("bills",bills);
        return ResultMessage.createSuccessMessage("获取信息成功",map);
    }

    //获取默认的细项数据
    @RequestMapping("/modeldata")
    @ResponseBody
    public List<Model> modelData(@RequestBody Long checkid){
        List<Model> models = modelMapperWeng.selectByCheckId(checkid);
        return models;
    }

    //插入细项数据
    @RequestMapping("/insertmodeldata")
    @ResponseBody
    public List<ModelData> insertModelData(@RequestBody List<Model> models, Long billid, Long usercheckid,HttpSession session) throws Exception {
        List<ModelData> modelDatas = new ArrayList<>();
        for (Model model:models){
            ModelData modelData = new ModelData();
            modelData.setModelvalue(model.getRecorddefault());
            modelData.setRecordid(model.getRecordid());
            modelData.setUsercheckid(usercheckid);
            modelDatas.add(modelData);
        }
        //暂存医生id
        Long accountid = ((Account)session.getAttribute("login-account")).getAccountid();
        Long doctorid = doctorMapperWeng.selectDeptByAccountId(accountid).getDoctorid();
        doctorCheckService.insertModelDataAndChangeBill(modelDatas,billid,doctorid);
        return modelDatas;
    }

    //小结编写界面
    @RequestMapping("/summary")
    public String summary(){

        return "doctorcheck/summary";
    }

    //小结保存
    @RequestMapping("/submitsummary")
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultMessage submitSummary(@RequestParam("summary") String summary,@RequestParam("billid") Long billid){
        System.out.println(summary);
        Report report = new Report();
        report.setBillid(billid);
        report.setReportsummary(summary);
        reportMapperWeng.updateSummaryByBillid(report);
        return ResultMessage.createSuccessMessage("成功添加小结,在后台确认后可正式提交","/doctorcheck/userinfo/index");
    }
}
