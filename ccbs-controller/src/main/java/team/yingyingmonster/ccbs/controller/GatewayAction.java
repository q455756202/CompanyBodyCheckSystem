package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.image.ImageUtil;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;


import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

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
        return "gateway/index";
    }

  /*  @RequestMapping("/success")
    public String success(HttpSession session){
        Account account=(Account) session.getAttribute("login-account");
        if (account.getAccountid()!=null){
            return "main/index";
        }else {
            return "redirect:/";
        }

    }*/

    @RequestMapping("/login")
    @ResponseBody
    public ResultMessage login(HttpSession session, Long accountId, String accountPassword,String userCode){
        String msg="";
        String keyCode=String.valueOf(session.getAttribute("keyCode"));
        if (keyCode.toLowerCase().equals(userCode.toLowerCase())){
            Account account=accountService.login(accountId,accountPassword);
            if(account!=null){
                session.setAttribute(Constant.SESSION_LOGIN_ACCOUNT, account);
                msg="登陆成功";
                return ResultMessage.createSuccessMessage(msg,null);
            }else {
                msg="账号或者密码错误！";
                return ResultMessage.createErrorMessage(msg);

            }
        }else {
            msg="验证码错误！";
            return ResultMessage.createErrorMessage(msg);

        }

    }

    @RequestMapping("/code-image")
    @ResponseBody
    public ResultMessage codeImage(HttpSession session){
        Map<String,BufferedImage> imageb=ImageUtil.createImage();
        //得到验证码
        String code=imageb.keySet().iterator().next();
        session.setAttribute("keyCode",code);
        //得到图片
        BufferedImage image=imageb.get(code);
        byte[] bytes=null;
        try {
            bytes=ImageUtil.imageToBytes(image,"PNG");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bytes!=null){
            return ResultMessage.createSuccessMessage(null,bytes);
        }else {
            return ResultMessage.createErrorMessage("未获取到验证码！");
        }
    }

    @RequestMapping("/register")
    public String register(){
        return "gateway/register";
    }

}
