package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerUser;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerCompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserCheckMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.GuideShowService;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    private JuerUserMapper juerUserMapper;
    @Autowired
    private JuerCompanyCheckSystemService juerCompanyCheckSystemService;

    @RequestMapping("/index")
    public String index() {
        return "guide-show/success";
    }

    @RequestMapping("/render")
    public String render() {
        return "guide-show/render-page";
    }

    @RequestMapping("/get-guide-list")
    @ResponseBody
    public ResultMessage getGuide(HttpSession session) {
        Long accountid = ((Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid();
        return ResultMessage.createSuccessMessage(
                "success!",
                guideShowService.getTeamformList(
                        juerCompanyMapper.selectCompanyByAccountId(accountid).getCompanyid()
                ));
    }

    @RequestMapping("/get-user-list")
    @ResponseBody
    public ResultMessage getCheckUserList(Long teamformid, HttpSession session) {
        Long companyid = juerCompanyMapper.selectCompanyByAccountId(((Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid()).getCompanyid();
        List<JuerUser> list = juerCompanyCheckSystemService.getJuerUsersByTeamformId(teamformid);
        System.out.println(JsonUtil.beanToJson(list, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
        return ResultMessage.createSuccessMessage(
                "success!",
                list
        );
    }

    @RequestMapping("/get-user-check")
    @ResponseBody
    public ResultMessage getUserCheck(@RequestBody Long usercheckid) {
        return ResultMessage.createSuccessMessage("success!", juerUserMapper.selectJuerUserByUsercheckid(usercheckid));
    }
}
