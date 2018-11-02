package team.yingyingmonster.ccbs.database.mapper.zhw;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 17:00 2018/11/2
 * -
 **/
@Repository
public interface ZhaoAccountMapper {
    List<Account> selectAccountByCondition(Account condition);
}
