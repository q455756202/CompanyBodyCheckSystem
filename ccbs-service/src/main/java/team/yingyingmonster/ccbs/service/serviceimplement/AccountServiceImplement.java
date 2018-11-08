package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerCompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.zhw.ZhaoAccountMapper;
import team.yingyingmonster.ccbs.database.mapper.zhw.ZhaoUserMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:51 2018/11/2
 * -
 **/
@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    private ZhaoAccountMapper zhaoAccountMapper;

    @Autowired
    private JuerCompanyMapper juerCompanyMapper;

    @Autowired
    private ZhaoUserMapper zhaoUserMapper;

    @Override
    public Account login(Long accountId, String accountPassword) {
        Account account = new Account();
        account.setAccountid(accountId);
        account.setAccountpassword(accountPassword);
        List<Account> accountList = zhaoAccountMapper.selectAccountByCondition(account);
        if (accountList != null) {
            account = accountList.get(0);
            return account;
        } else {
            account = null;
            return account;
        }

    }

    @Override
    public Long addAccount(String accountName, String accountPassword, String companyPhone, String companyEmail) {
        Account account = new Account();
        account.setAccountname(accountName);
        account.setAccountpassword(accountPassword);
        Long insertNum = zhaoAccountMapper.addAccount(account);
        if (insertNum != null) {
            Company company = new Company();
            company.setAccountid(account.getAccountid());
            company.setCompanyphone(companyPhone);
            company.setCompanyemail(companyEmail);
            Integer result = zhaoAccountMapper.addCompany(company);
            if (result > 0) {
                return account.getAccountid();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Company selectCompany(Long accountId) {
        Company company = null;
        company = zhaoAccountMapper.selectCompany(accountId);
        return company;
    }

    /**
     * 通过账户ID查找公司ID
     */
    @Override
    public Long findCompanyId(Long accountId) {
        Long companyId = juerCompanyMapper.selectCompanyByAccountId(accountId).getCompanyid();
        return companyId;
    }

    /**
     * 插入体检人员信息
     */
    @Override
    public Integer insertUsers(Long companyId, List<String[]> userList) {
        Integer result=0;
        User user = new User();
        List<User> users = new ArrayList<User>();
        for (String[] userInfo : userList) {
            Long userId = zhaoUserMapper.getNewUserId();
            user.setUserid(userId);
            user.setCompanyid(companyId);
            user.setUsername(userInfo[0]);
            user.setUsergender((short)(userInfo[1].equals("男")?0:1));
            user.setUserage(Short.valueOf(userInfo[2]));
            user.setUserphone(userInfo[3]);
            user.setUsercardcode(userInfo[4]);
            users.add(user);
        }
        List<User> beforeUsers = new ArrayList<User>();
        beforeUsers=zhaoUserMapper.selectBeforeUsers(companyId);
        for(int i=0; i<beforeUsers.size(); i++){
            for(int j=0;j<users.size();j++){
                if(beforeUsers.get(i).equals(users.get(j).getUsercardcode())){
                    users.remove(users.get(j));
                }
            }
        }
        if (users!=null){
            result = zhaoAccountMapper.insertUsers(users);
        }
        System.out.println("插入信息的条数：" + result);
        return result;
    }
}
