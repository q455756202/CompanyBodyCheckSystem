package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 菜单
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Menu {
    private Long menuid;
    private String menuname;
    private String menuurl;
    private Short menustate;
}