package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;

public interface AccountService {
    Account login(Long accountId, String accountPassword);
    Long addAccount(String accountName,String accountPassword);
    boolean addCompany(Long accountId,String companyPhone,String companyEmail);
}
