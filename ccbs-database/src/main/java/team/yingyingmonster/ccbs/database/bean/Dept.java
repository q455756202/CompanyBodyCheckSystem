package team.yingyingmonster.ccbs.database.bean;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Dept {
    private Long deptid;
    private String deptname;
}