package team.yingyingmonster.ccbs.database.bean.juergenie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.yingyingmonster.ccbs.database.bean.Combo;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:08 2018/11/4
 * -
 **/
@Getter
@Setter
@ToString
public class JuerCombo extends Combo {
    private List<User> userList = new LinkedList<>();
}
