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
public class UserCheck {
    private Long usercheckid;
    private Long userid;
    private Long teamformcombocheckid;

    @SerializedName("teamformCombocheck")
    private TeamformCombocheck teamformCombocheckByTeamformCombocheckid;
    @SerializedName("billList")
    private List<Bill> billsByUsercheckid;
    @SerializedName("modelDataList")
    private List<ModelData> modeldataByUsercheckid;
    @SerializedName("user")
    private User userByUserid;
}
