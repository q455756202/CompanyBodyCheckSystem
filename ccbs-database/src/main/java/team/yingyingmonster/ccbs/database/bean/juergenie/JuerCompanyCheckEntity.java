package team.yingyingmonster.ccbs.database.bean.juergenie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.LinkedList;
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
    private List<JuerCombo> comboList = new LinkedList<>();
    private List<JuerCombo> selectCombo = new LinkedList<>();
    private List<User> userList = new LinkedList<>();
}
