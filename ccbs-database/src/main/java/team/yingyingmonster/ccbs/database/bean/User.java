package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private Long userid;
    private Long companyid;
    private String username;
    private Short usergender;
    private Short userage;
    private String userphone;
    private String usercardcode;

    private Company companyByCompanyid;
}