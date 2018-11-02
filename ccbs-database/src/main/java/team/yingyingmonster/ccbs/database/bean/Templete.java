package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Templete {
    private Long templeteid;
    private Long doctorid;
    private String templetename;
    private Date templetecreatedate;
    private Short templetestate;
    private String templetepath;

    private Doctor doctorByDoctorid;
}