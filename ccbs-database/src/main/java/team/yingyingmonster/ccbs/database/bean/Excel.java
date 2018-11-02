package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Excel {
    private Long excelid;
    private Long companyid;
    private String excelname;
    private String excelurl;

    private Company companyByCompanyid;
}