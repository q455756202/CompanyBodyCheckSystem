package team.yingyingmonster.ccbs.database.bean.juergenie;

import lombok.*;
import team.yingyingmonster.ccbs.database.bean.Check;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:11 2018/11/8
 * -
 **/
@Getter
@Setter
@ToString
public class JuerUser extends User {
    Long usercheckid;
    List<Check> checkList;
}
