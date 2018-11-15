package team.yingyingmonster.ccbs.controller;

import com.google.gson.JsonObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.*;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerComboMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerCompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserMapper;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/index")
    public String index() {
        return "company-check/index";
    }

    @RequestMapping("/success")
    public String success() {
        return "guide-show/success";
    }

    @RequestMapping("/error")
    public String error() {
        return "company-check/error";
    }

    /**
     * 获取团检报名实体。
     * @param session
     * @return
     */
    @RequestMapping("/get-company-entity")
    @ResponseBody
    public ResultMessage getCompanyEntity(HttpSession session) {
        Account account = (Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT);
        JuerCompanyCheckEntity entity = juerCompanyCheckSystemService.getCompanyCheckEntity(account.getAccountid());
        return entity==null?ResultMessage.createErrorMessage("未取到数据！"):ResultMessage.createSuccessMessage("success!", entity);
    }

    /**
     * 提交团检报名实体
     * @param juerCompanyCheckEntity
     * @return
     */
    @RequestMapping("/submit-company-check")
    @ResponseBody
    public ResultMessage submitCompanyCheck(@RequestBody JuerCompanyCheckEntity juerCompanyCheckEntity) {
        try {
            juerCompanyCheckSystemService.registerCompanyCheck(juerCompanyCheckEntity);
            return ResultMessage.createSuccessMessage("success!", "/guide-show/index");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMessage.createErrorMessage(e.getMessage());
        }
    }
}
