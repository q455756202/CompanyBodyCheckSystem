package team.yingyingmonster.ccbs.service.serviceimplement;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.dingli.AccountListMapper;
import team.yingyingmonster.ccbs.database.mapper.AccountMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.AccountService;

import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:51 2018/11/2
 * -
 **/
@Service
public class AccountServiceImplement implements AccountService {
    private String flag;

    private List accountList;

    @Autowired
    private AccountListMapper accountListMapper;
    private AccountMapper accountMapper;
    @Override
    public List<Account> selectByPrimaryKey(Long accountid) {
        return null;
    }

    @Override
    public PageInfo<Account> selectAccountPage(Integer pageNum, Integer pageSize) {

        if (pageNum == null)

            pageNum = 1;

        if (pageSize == null)

            pageSize = 5;



        Page<Account> page = PageHelper.startPage(pageNum, pageSize);

        List<Account> list = accountListMapper.selectAllAccount();



        return new PageInfo<>(page);

    }

    @Override
    public int insertAccount(Account account) {
        return accountMapper.insert(account);
    }
}
