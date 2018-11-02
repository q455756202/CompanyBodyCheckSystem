package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Account;

public interface AccountService {
    Account login(Long accountId, String accountPassword);
}
