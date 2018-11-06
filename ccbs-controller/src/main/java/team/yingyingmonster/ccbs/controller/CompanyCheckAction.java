package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerComboMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerCompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;

import javax.servlet.http.HttpSession;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:24 2018/11/2
 * -
 **/
@Controller
@RequestMapping("/company-check")
public class CompanyCheckAction {
    @Autowired
    private JuerCompanyCheckSystemService juerCompanyCheckSystemService;
    @Autowired
    private JuerUserMapper juerUserMapper;
    @Autowired
    private JuerComboMapper juerComboMapper;
    @Autowired
    private JuerCompanyMapper juerCompanyMapper;

    @RequestMapping("/index")
    public String index() {
        return "company-check/index";
    }

    @RequestMapping("/success")
    public String success() {
        return "company-check/success";
    }

    @RequestMapping("/error")
    public String error() {
        return "company-check/error";
    }

    @RequestMapping("/get-company-user")
    @ResponseBody
    public ResultMessage getCompanyUser(HttpSession session) {
        Account account = (Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT);
        if (account == null || account.getRoleid() != 1) {
            return ResultMessage.createErrorMessage("获取数据失败！");
        } else {
            Company company = juerCompanyMapper.selectCompanyByAccountId(account.getAccountid());
            return ResultMessage.createSuccessMessage("success!", juerUserMapper.selectUsersByCompanyid(company.getCompanyid()));
        }
    }

    @RequestMapping("/get-combo")
    @ResponseBody
    public ResultMessage getCombo() {
        return ResultMessage.createSuccessMessage("success!", juerComboMapper.selectComboByCondition(null));
    }

    @RequestMapping("/get-company-entity")
    @ResponseBody
    public ResultMessage getCompanyEntity() {
        JuerCompanyCheckEntity entity = juerCompanyCheckSystemService.getCompanyCheckEntity(1l);
        System.out.println("\n========"+JsonUtil.beanToJson(entity, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL)+"\n========");
        return ResultMessage.createSuccessMessage("success!", entity);
    }

    @RequestMapping("/submit-company-check")
    @ResponseBody
    public ResultMessage submitCompanyCheck(@RequestBody JuerCompanyCheckEntity juerCompanyCheckEntity) {
        System.out.println(JsonUtil.beanToJson(juerCompanyCheckEntity, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
        return ResultMessage.createSuccessMessage("success!", "/company-check/success");
    }
}
