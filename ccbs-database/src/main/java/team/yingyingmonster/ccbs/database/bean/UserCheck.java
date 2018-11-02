package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserCheck {
    private Long usercheckid;
    private Long userid;
    private Long teamformcombocheckid;

    private TeamformCombocheck teamformCombocheckByTeamformCombocheckid;
}