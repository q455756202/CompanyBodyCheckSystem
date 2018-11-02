package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Model {
    private Long recordid;
    private Long checkid;
    private String recordname;

    private Check checkByCheckid;
}