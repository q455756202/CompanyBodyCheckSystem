package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;

@Repository
public interface AccountMapper {
    List<Account> selectByPrimaryKey(Long accountid);
    int deleteByPrimaryKey(Long accountid);
    int insert(Account account);
    int insertSelective(Account list);
    int updateByPrimaryKeySelective(Account list);
    int updateByPrimaryKey(Account account);
}
