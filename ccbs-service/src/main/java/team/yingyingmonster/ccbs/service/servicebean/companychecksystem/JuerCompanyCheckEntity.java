package team.yingyingmonster.ccbs.service.servicebean.companychecksystem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.yingyingmonster.ccbs.database.bean.Combo;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:06 2018/11/4
 * - 用于构建组织团检订单的实体。
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class JuerCompanyCheckEntity {
    private Company company;
    private List<Combo> comboCheckList;
    private List<User> userList;
}
