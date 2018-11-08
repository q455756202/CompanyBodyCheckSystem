package team.yingyingmonster.ccbs.service.serviceinterface;

public interface AccountService {
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;

import java.util.List;


public interface AccountService {
    Account login(Long accountId, String accountPassword);
    Long addAccount(String accountName,String accountPassword,String companyPhone,String companyEmail);
    Company selectCompany(Long accountId);
    Long findCompanyId(Long accountId);//通过账户ID查找公司ID
    Integer insertUsers(Long companyId, List<String[]> userList);//插入体检人员信息
}
