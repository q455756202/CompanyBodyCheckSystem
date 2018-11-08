package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:32 2018/11/2
 * - 角色菜单关系
 **/

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "ROLE_MENU_TABLE")
public class RoleMenu {
    private Long roleId;
    private Long menuId;

    private Role roleByRoleId;
    private Menu menuByMenuId;
}
