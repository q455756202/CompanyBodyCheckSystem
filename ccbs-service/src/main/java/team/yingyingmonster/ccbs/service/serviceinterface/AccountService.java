package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;

public interface AccountService {
    Account login(Long accountId, String accountPassword);
    boolean addAccount(String accountName,String accountPassword,String companyPhone,String companyEmail);
}
