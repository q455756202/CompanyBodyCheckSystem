package team.yingyingmonster.ccbs.database.dingli;


import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Account;

import java.util.List;
@Repository
public interface AccountListMapper {
   List<Account> selectAllAccount();
}
