package team.yingyingmonster.ccbs.service.serviceinterface;

import com.github.pagehelper.PageInfo;
import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;

public interface AccountService {
    List<Account> selectByPrimaryKey(Long accountid);
    PageInfo<Account> selectAccountPage(Integer pageNum, Integer pageSize);
    int insertAccount(Account account);
}
