package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:51 2018/11/2
 * -   该文件由赵寒威接管
 **/
@Service
public class AccountServiceImplement implements AccountService {
    @Override
    public Account login(Long accountId, String accountPassword) {
        return null;
    }
}
