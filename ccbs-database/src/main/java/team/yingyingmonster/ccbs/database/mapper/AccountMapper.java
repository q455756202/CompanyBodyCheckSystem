package team.yingyingmonster.ccbs.database.mapper;

import org.apache.ibatis.annotations.Param;
import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> selectByPrimaryKey(Long accountid);
    int deleteByPrimaryKey(Long accountid);
    int insert(Account account);
    int insertSelective(Account list);
    int updateByPrimaryKeySelective(Account list);
    int updateByPrimaryKey(Account account);
    Account loginAccount(@Param("accountId")Long accountId, @Param("accountPassword")String accountPassword);

}
