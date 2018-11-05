package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.mapper.zhw.ZhaoAccountMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;

import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:51 2018/11/2
 * -   该文件由赵寒威接管
 **/
@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    private ZhaoAccountMapper zhaoAccountMapper;

    @Override
    public Account login(Long accountId, String accountPassword) {
        Account account = new Account();
        account.setAccountid(accountId);
        account.setAccountpassword(accountPassword);
        List<Account> accountList = zhaoAccountMapper.selectAccountByCondition(account);
        if (accountList!=null){
            account=accountList.get(0);
            return account;
        }else {
            account=null;
            return account;
        }

    }

    @Override
    public Long addAccount(String accountName, String accountPassword) {
        Account account = new Account();
        account.setAccountname(accountName);
        account.setAccountpassword(accountPassword);
        Long result= Long.valueOf(zhaoAccountMapper.addAccount(account));
        return result;
    }

    @Override
    public boolean addCompany(Long accountId, String companyPhone, String companyEmail) {
        Company company=new Company();
        company.setAccountid(accountId);
        company.setCompanyphone(companyPhone);
        company.setCompanyemail(companyEmail);
        Integer result=zhaoAccountMapper.addCompany(company);
        return result>0;
    }
}
