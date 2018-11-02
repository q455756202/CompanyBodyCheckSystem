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
public class Log {
    private Long logid;
    private Date logtime;
    private String loglevel;
    private String logclass;
    private String loglocate;
    private String logthread;
    private String logmessage;
}