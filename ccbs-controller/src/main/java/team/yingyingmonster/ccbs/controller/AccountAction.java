package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:17 2018/11/5
 * - 团检单位账户信息处理
 **/

@Controller
@RequestMapping("/account")
public class AccountAction {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account-info")
    @ResponseBody
    public ResultMessage accountInfo(HttpSession session){
        Account account=(Account)session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT);
        if (account!=null){
            Company company=accountService.selectCompany(account.getAccountid());
            if (company!=null){
                Map<String,Object> map=new ManagedMap<>();
                map.put("account",account);
                map.put("company",company);
                return ResultMessage.createSuccessMessage(null,map);
            }else {
                return ResultMessage.createErrorMessage("没有获取到账户信息");
            }
        }else {
            return ResultMessage.createErrorMessage("请重新登入");
        }

    }



}
