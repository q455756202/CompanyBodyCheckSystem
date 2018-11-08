package team.yingyingmonster.ccbs.service.serviceinterface;

import com.github.pagehelper.PageInfo;
import team.yingyingmonster.ccbs.database.bean.Account;

public interface AccountService {
    Account login(Long accountId, String accountPassword);
    Long addAccount(String accountName,String accountPassword);
    boolean addCompany(Long accountId,String companyPhone,String companyEmail);
    PageInfo<Account> selectAccountPage(Integer pageNum,Integer pageSize);
}
