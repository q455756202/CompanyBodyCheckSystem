package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 账户表（Account_Table）
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    private Long accountid;
    private Long roleid;
    private String accountname;
    private String accountpassword;
    private Short accountstate;
    private Date registerdate;

    private Role roleByRoleid;
}