package team.yingyingmonster.ccbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.poi.POIUtils;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;
import team.yingyingmonster.ccbs.service.serviceinterface.CompanyService;
import team.yingyingmonster.ccbs.service.serviceinterface.UserService;
import team.yingyingmonster.ccbs.web.WebUtil;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:17 2018/11/5
 * - 团检单位账户信息处理
 **/

@Controller
@RequestMapping("/company-info")
public class AccountAction {
    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/index")
    public String index(){
        return "/company-info/account-info";
    }


    @RequestMapping("/account-register")
    @ResponseBody
    public ResultMessage register(@RequestBody Map<String, Object> map) {
        Long accountId = accountService.addAccount(map.get("accountName").toString(), map.get("accountPassword").toString(), map.get("companyPhone").toString(), map.get("companyEmail").toString());
        String msg = "";
        if (accountId > 0) {
            msg = "注册成功";
            return ResultMessage.createSuccessMessage(msg, accountId);
        } else {
            msg = "注册失败";
            return ResultMessage.createErrorMessage(msg);
        }
    }

    @RequestMapping("/account-info")
    @ResponseBody
    public ResultMessage accountInfo(HttpSession session) {
        Account account = (Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT);
        if (account != null) {
            Company company = companyService.selectCompany(account.getAccountid());
            if (company != null) {
                Map<String, Object> map = new ManagedMap<>();
                map.put("account", account);
                map.put("company", company);
                return ResultMessage.createSuccessMessage(null, map);
            } else {
                return ResultMessage.createErrorMessage("没有获取到账户信息");
            }
        } else {
            return ResultMessage.createErrorMessage("请重新登入");
        }
    }

    /*
    * 添加体检人员名单
    */
    @RequestMapping("/user-list")
    @ResponseBody
    public ResultMessage userNameList(@RequestParam(value = "userNameList", required = true) MultipartFile file, HttpSession session) {
        Long accountId = ((Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid();
        String filename = "test/files/" + accountId + ".xlsx";
        String path = WebUtil.getRealPath(session, filename);
        File nameFile = new File(path);
        if (!nameFile.getParentFile().exists()) {
            nameFile.getParentFile().mkdirs();
        }
        List<String[]> list = null;
        try {
            file.transferTo(nameFile);
            list = POIUtils.readExcelAndNotCheck(nameFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultMessage.createErrorMessage(e.getMessage());
        }
        return ResultMessage.createSuccessMessage("success", list);
    }

    /*
    * 提交提交人员名单
    */
    @RequestMapping("/submit-users")
    @ResponseBody
    public ResultMessage submitUsers(@RequestBody List<String[]> userList, HttpSession session){
        Long accountId=((Account)session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid();
        Long companyId=accountService.findCompanyId(accountId);
        Integer result=userService.insertUsers(companyId,userList);
        if (result>0){
            return ResultMessage.createSuccessMessage("success",result);
        }else {
            return ResultMessage.createErrorMessage(null);
        }
    }

    /*
     * 查询体检人员名单
     */
    @RequestMapping("/select-users")
    @ResponseBody
    public ResultMessage selectUsers(HttpSession session){
        Long accountId=((Account)session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid();
        Long companyId=accountService.findCompanyId(accountId);
        return ResultMessage.createSuccessMessage(null,null);
    }

}
