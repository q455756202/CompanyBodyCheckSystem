package team.yingyingmonster.ccbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:50 2018/11/2
 * -
 **/

@Controller
@RequestMapping("/gateway")
public class GatewayAction {

    //private AccountMapper accountMapper;
    //private Account account= new Account();
    @RequestMapping("/index")
    public String index(){
        return "login/index";
    }

    @RequestMapping("/login")
    public String loginAction(Long accountId,String accountPassword){
        //account=accountMapper;
        return "";
    }

}
