package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 配置表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Config {
    private Long configid;
    private String configname;
    private String configvalue;
}