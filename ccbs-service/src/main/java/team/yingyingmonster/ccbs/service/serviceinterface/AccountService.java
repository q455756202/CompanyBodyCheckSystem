package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;


public interface AccountService {
    Account login(Long accountId, String accountPassword);
    Long addAccount(String accountName,String accountPassword,String companyPhone,String companyEmail);
    Long findCompanyId(Long accountId);//通过账户ID查找公司ID

}
