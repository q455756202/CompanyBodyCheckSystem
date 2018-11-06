package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;

import java.util.List;

public interface AccountService {
    Account login(Long accountId, String accountPassword);
    Long addAccount(String accountName,String accountPassword,String companyPhone,String companyEmail);
    Company selectCompany(Long accountId);
}
