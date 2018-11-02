package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Teamform {
    private Long teamformid;
    private Long companyid;
    private Short teamformstate;

    private Company companyByCompanyid;
}