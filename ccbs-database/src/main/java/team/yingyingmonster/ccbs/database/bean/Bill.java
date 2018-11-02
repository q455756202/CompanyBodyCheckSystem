package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 记账记录表（Bill_Table）
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Bill {
    private Long billid;
    private Long usercheckid;
    private Long checkid;
    private Short billstate;
    private Date billdate;

    private UserCheck userCheckByUsercheckid;
    private Check checkByCheckid;
}