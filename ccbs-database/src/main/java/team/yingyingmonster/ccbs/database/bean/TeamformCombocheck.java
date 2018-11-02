package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TeamformCombocheck {
    private Long teamformcombocheckid;
    private Long teamformid;
    private Long comboid;

    private Combo comboByComboid;
    private Teamform teamformByTeamformid;
}