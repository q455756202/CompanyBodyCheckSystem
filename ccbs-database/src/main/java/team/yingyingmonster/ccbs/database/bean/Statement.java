package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Statement {
    private Long statementid;
    private Long companyid;
    private BigDecimal statementprice;
    private Date statementdate;
    private Short statementtype;

    private Company companyByCompanyid;
}