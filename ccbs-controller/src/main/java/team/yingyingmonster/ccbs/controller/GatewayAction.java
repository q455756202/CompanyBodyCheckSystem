package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.mapper.AccountMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:50 2018/11/2
 * -
 **/

@Controller
@RequestMapping("/gateway")
public class GatewayAction {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/index")
    public String index(){
        return "login/index";
    }

    @RequestMapping("/login")
    public String loginAction(Long accountId,String accountPassword){
        Account account= new Account();

        account=accountService.login(accountId,accountPassword);
        return "common/index.html";
    }

}
