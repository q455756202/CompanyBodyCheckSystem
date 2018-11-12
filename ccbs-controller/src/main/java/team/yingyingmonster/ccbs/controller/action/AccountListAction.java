package team.yingyingmonster.ccbs.controller.action;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.mapper.dingli.AccountListMapper;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:31 2018/11/7
 * - 账户管理信息列表展示
 **/
@Controller
@RequestMapping("/accountList")
public class AccountListAction {
    @Autowired
    private AccountListMapper accountListMapper;
    @RequestMapping("/index")
    public String index() {
        return "background-management/account-management";
    }
    @RequestMapping("/get-accountList")
    @ResponseBody
    public ResultMessage getAccount() {
        PageHelper.startPage(1,5);
        PageHelper.orderBy("ACCOUNTID");
        return ResultMessage.createSuccessMessage("success!",accountListMapper.selectAllAccount());
    }

}
