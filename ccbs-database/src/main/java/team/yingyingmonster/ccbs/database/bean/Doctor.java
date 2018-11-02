package team.yingyingmonster.ccbs.database.bean;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Doctor {
    private Long doctorid;
    private Long accountid;
    private Long deptid;
    private Short doctorgender;
    private Short doctorage;
    private String doctorphone;
    private String doctorheader;

    private Account accountByAccountid;
    private Dept deptByDeptid;
}