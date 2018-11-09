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
public class Report {
    private Long reportid;
    private Long billid;
    private Date reportdate;
    private String reportsummary;
    private Short reportstate;
    private Long doctorid;

    private Bill billByBillid;
    private Doctor doctorByDoctorid;
}