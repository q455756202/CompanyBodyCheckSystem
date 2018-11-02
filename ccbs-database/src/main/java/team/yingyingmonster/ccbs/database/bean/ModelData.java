package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ModelData {
    private Long modeldataid;
    private Long recordid;
    private Long usercheckid;
    private String modelvalue;

    private UserCheck userCheckByUsercheckid;
    private Model modelByRecordid;
}