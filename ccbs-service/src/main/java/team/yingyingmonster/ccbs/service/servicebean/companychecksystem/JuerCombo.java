package team.yingyingmonster.ccbs.service.servicebean.companychecksystem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.yingyingmonster.ccbs.database.bean.User;

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
@EqualsAndHashCode
public class JuerCombo {
    private Long comboid;
    private String comboname;
    private List<User> userList;
}
