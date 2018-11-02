package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 公司表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Company {
    private Long companyid;
    private Long accountid;
    private BigDecimal companyprice;
    private String companyemail;
    private String companyphone;

    private Account accountByAccountid;
}