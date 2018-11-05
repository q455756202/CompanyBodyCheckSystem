package team.yingyingmonster.ccbs.database.bean;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TeamformCombocheck {
    private Long teamformcombocheckid;
    private Long teamformid;
    private Long comboid;

    @SerializedName("combo")
    private Combo comboByComboid;
    @SerializedName("teamform")
    private Teamform teamformByTeamformid;
    @SerializedName("userCheckList")
    private List<UserCheck> userCheckByTeamformid;
}