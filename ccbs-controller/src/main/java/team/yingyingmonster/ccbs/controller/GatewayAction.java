package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.yingyingmonster.ccbs.common.ImageUtil;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;


import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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

    @RequestMapping("/login")
    public String login(Long accountId,String accountPassword){
        Account account= new Account();

        account=accountService.login(accountId,accountPassword);
        return "common/index.html";
    }

    @RequestMapping("/code-image")
    public ResultMessage codeImage(HttpServletRequest req){
        Map<String,BufferedImage> imageb=ImageUtil.createImage();
        //得到验证码
        String code=imageb.keySet().iterator().next();
        req.getSession().setAttribute("keyCode",code);
        //得到图片
        BufferedImage image=imageb.get(code);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();




    }
}
