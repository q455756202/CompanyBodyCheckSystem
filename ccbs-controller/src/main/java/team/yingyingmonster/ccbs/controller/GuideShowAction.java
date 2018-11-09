package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerCompanyMapper;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.GuideShowService;

import javax.servlet.http.HttpSession;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:29 2018/11/9
 * - 导检单展示模块
 **/
@Controller
@RequestMapping("/guide-show")
public class GuideShowAction {
    @Autowired
    private GuideShowService guideShowService;
    @Autowired
    private JuerCompanyMapper juerCompanyMapper;

    @RequestMapping("/index")
    public String index() {
        return "guide-show/success";
    }

    @RequestMapping("/get-guide")
    @ResponseBody
    public ResultMessage getGuide(HttpSession session) {
        Long accountid = ((Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid();
        return ResultMessage.createSuccessMessage("success!", guideShowService.getTeamformList(juerCompanyMapper.selectCompanyByAccountId(accountid).getCompanyid()));
    }
}
