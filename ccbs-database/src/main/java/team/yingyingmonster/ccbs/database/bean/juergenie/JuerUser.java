package team.yingyingmonster.ccbs.database.bean.juergenie;

import team.yingyingmonster.ccbs.database.bean.Check;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:11 2018/11/8
 * -
 **/
public class JuerUser extends User {
    Long usercheckid;
    List<Check> checkList;
}
