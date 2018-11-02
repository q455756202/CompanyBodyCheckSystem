package team.yingyingmonster.ccs.controller.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 11:07 2018/10/30
 * - 生成二维码需要的实体类
 **/

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FiveElements {
    private String name;
    private String gender;
    private String idType;
    private String idno;
    private String mobile;
}
