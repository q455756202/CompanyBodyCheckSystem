package team.yingyingmonster.ccbs.database.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 套餐表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Combo {
    private Long comboid;
    private String comboname;
    private String combosummary;
    private BigDecimal comboratio;
}