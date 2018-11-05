package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 体检套餐表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ComboCheck {
    private Long combocheckid;
    private Long checkid;
    private Long comboid;

    private Check checkByCheckid;
    private Combo comboByComboid;
}